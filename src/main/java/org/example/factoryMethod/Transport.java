package org.example.factoryMethod;

import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.NoSuchModelNameException;

public interface Transport {
    public String getMark();
    public void setMark(String markCar);
    public void setModelTitle(String oldTitle, String newTitle) throws NoSuchModelNameException, DuplicateModelNameException;
    public String[] getAllTitle();
    public double getModelPrice(String title) throws NoSuchModelNameException;
    public void setModelPrice(String title, double newPrice) throws NoSuchModelNameException;
    public double[] returnAllPrice();
    public void addModel(String title, double price) throws DuplicateModelNameException;
    public void removeModel(String title) throws NoSuchModelNameException;
    public int sizeModel();
    public void accept(Visitor visitor);
}
