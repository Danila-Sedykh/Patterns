package org.example.factoryMethod;

import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.NoSuchModelNameException;

public class Decorator implements Transport {
    private Transport transport;

    public Decorator(Transport transport){
        this.transport = transport;
    }

    @Override
    public synchronized String getMark() {
        return transport.getMark();
    }

    @Override
    public synchronized void setMark(String markCar) {
        transport.setMark(markCar);
    }

    @Override
    public synchronized void setModelTitle(String oldTitle, String newTitle) throws NoSuchModelNameException, DuplicateModelNameException {
        transport.setModelTitle(oldTitle,newTitle);
    }

    @Override
    public synchronized String[] getAllTitle() {
        return transport.getAllTitle();
    }

    @Override
    public synchronized double getModelPrice(String title) throws NoSuchModelNameException {
        return transport.getModelPrice(title);
    }

    @Override
    public synchronized void setModelPrice(String title, double newPrice) throws NoSuchModelNameException {
        transport.setModelPrice(title,newPrice);
    }

    @Override
    public synchronized double[] returnAllPrice() {
        return transport.returnAllPrice();
    }

    @Override
    public synchronized void addModel(String title, double price) throws DuplicateModelNameException {
        transport.addModel(title,price);
    }

    @Override
    public synchronized void removeModel(String title) throws NoSuchModelNameException {
        transport.removeModel(title);
    }

    @Override
    public synchronized int sizeModel() {
        return transport.sizeModel();
    }

    @Override
    public void accept(Visitor visitor) {
        transport.accept(visitor);
    }


}
