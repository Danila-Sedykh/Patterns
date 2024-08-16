package org.example.factoryMethod;

import org.example.command.Command;
import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.ModelPriceOutOfBoundsException;
import org.example.factoryMethod.exception.NoSuchModelNameException;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Transport, Cloneable, Serializable {
    private String mark;
    private Model[] models;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    protected static class Model implements Serializable{
        String title;
        double price;


        public Model(String title, double price) {
            this.title = title;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice() {
            return price;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return title + " - " + price;
        }
    }

    public Iterator iterator() {
        return new AutoIterator();
    }

    private class AutoIterator implements Iterator {
        int i ;

        @Override
        public boolean hasNext() {
            if (i < models.length) {
                return true;
            }
            return false;
        }

        @Override
        public Model next() {
            if (this.hasNext()){
                return models[i++];
            }
            return null;
        }
    }

    public Car(String markCar, int size) {
        this.mark = markCar;
        models = new Model[size];
        for (int i = 0; i < models.length; i++) {
            models[i] = new Model("210" + (i + 1), (i + 1) * 100);
        }
    }

    public void setModelTitle(String oldTitle, String newTitle) throws NoSuchModelNameException, DuplicateModelNameException {
        int idOldTitle = -1;
        for (int i = 0; models.length > i; i++) {
            if (models[i].getTitle().equals(newTitle)) {
                throw new DuplicateModelNameException(newTitle);
            }
            if (models[i].getTitle().equals(oldTitle)) {
                idOldTitle = i;
            }
        }
        if (idOldTitle == -1) {
            throw new NoSuchModelNameException(oldTitle);
        }
        models[idOldTitle].setTitle(newTitle);
    }

    public String[] getAllTitle() {
        String[] allTitle = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            allTitle[i] = models[i].getTitle();
        }
        return allTitle;
    }

    public double getModelPrice(String title) throws NoSuchModelNameException {
        for (int i = 0; i < models.length; i++) {
            if (models[i].getTitle().equals(title)) {
                return models[i].getPrice();
            }
        }
        throw new NoSuchModelNameException(title);
    }

    public void setModelPrice(String title, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        for (int i = 0; i < models.length; i++) {
            if (models[i].getTitle().equals(title)) {
                models[i].setPrice(newPrice);
                return;
            }
        }
        throw new NoSuchModelNameException(title);
    }


    public double[] returnAllPrice() {
        double[] allPrice = new double[models.length];
        for (int i = 0; i < models.length; i++) {
            allPrice[i] = models[i].getPrice();
        }
        return allPrice;
    }

    public void addModel(String title, double price) throws DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        for (int i = 0; i < models.length; i++) {
            if (models[i].getTitle().equals(title)) {
                throw new DuplicateModelNameException(title);
            }
        }
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(title, price);
    }

    public void removeModel(String title) throws NoSuchModelNameException {
        for (int i = 0; i < models.length; i++) {
            if (models[i].getTitle().equals(title)) {
                System.arraycopy(models, i + 1, models, i, models.length - i - 1);
                models = Arrays.copyOf(models, models.length - 1);
                return;
            }
        }
        throw new NoSuchModelNameException(title);

    }

    public int sizeModel() {
        return models.length;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Car clone() throws CloneNotSupportedException {
        Car cloneCar = (Car) super.clone();
        cloneCar.models = new Model[models.length];
        for (int i = 0; i < models.length; i++) {
            cloneCar.models[i] = new Model(models[i].title, models[i].price);
        }
        return cloneCar;
    }

    public void print(Car car, FileWriter fileWriter) throws IOException {
        if (fileWriter != null) {
            printCommand.printTransport(car, fileWriter);
        }

    }

    private Command printCommand;

    public void setPrintCommand(Command command) {
        this.printCommand = command;
    }

    public static class Memento implements Serializable{
        byte[] bytes;
        public Memento(Car car) throws IOException {
            setAuto(car);
        }
        public void setAuto(Car car){
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(car);
                bytes = outputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
         public Car getAuto(){
             try {
                 ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                 ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                 return (Car) objectInputStream.readObject();
             } catch (IOException e) {
                 throw new RuntimeException(e);
             } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
             }
         }

    }
    public Memento createMemento() throws IOException {
        return new Memento(this);
    }
    public void setMemento(Memento memento){
        Car car = memento.getAuto();
        this.models = car.models;
        this.mark = car.mark;
        this.printCommand = car.printCommand;
    }
    public Model[] getModel(){
        return models;
    }


}
