package org.example.factoryMethod;

import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.ModelPriceOutOfBoundsException;
import org.example.factoryMethod.exception.NoSuchModelNameException;

public class Bike implements Transport, Cloneable {
    private String mark;
    private int size = 0;



    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    private class Model {
        String title = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {////
        }

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

    }

    private Model head = new Model();

    {
        head.prev = head;
        head.next = head;
    }

    public Bike(String markBike, int size) throws DuplicateModelNameException {
        this.mark = markBike;
        for (int i = 0; i < size; i++) {
            addModel("Z-" + (i + 1) + "00", (i + 1) * 100);
        }
    }

    public void setModelTitle(String oldTitle, String newTitle) throws NoSuchModelNameException, DuplicateModelNameException {
        Model point = head.next;
        Model poz = null;
        while (point != head) {
            if (point.getTitle().equals(newTitle)) {
                throw new DuplicateModelNameException(newTitle);
            }
            if (point.getTitle().equals(oldTitle)) {
                poz = point;
            }
            point = point.next;
        }
        if (poz == null){
            throw new NoSuchModelNameException(oldTitle);
        }
        poz.setTitle(newTitle);
    }

    public String[] getAllTitle() {
        String[] allTitle = new String[size];
        Model point = head.next;
        for (int i = 0; i < size; i++) {
            allTitle[i] = point.getTitle();
            point = point.next;
        }
        return allTitle;
    }

    public double getModelPrice(String title) throws NoSuchModelNameException {
        Model point = head.next;
        while (point != head) {
            if (point.getTitle().equals(title)) {
                return point.getPrice();
            }
            point = point.next;
        }
        throw new NoSuchModelNameException(title);
    }

    public void setModelPrice(String title, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        Model point = head.next;
        while (point != head) {
            if (point.getTitle().equals(title)) {
                point.setPrice(newPrice);
                return;
            }
            point = point.next;
        }
        throw new NoSuchModelNameException(title);
    }

    public double[] returnAllPrice() {
        double[] allPrice = new double[size];
        Model point = head.next;
        for (int i = 0; i < size; i++) {
            allPrice[i] = point.getPrice();
            point = point.next;
        }
        return allPrice;
    }

    public void addModel(String title, double price) throws DuplicateModelNameException {
        if (price < 0) {
            throw new ModelPriceOutOfBoundsException();
        }
        Model point = head.next;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (point.getTitle().equals(title)) {
                flag = true;
                break;
            }
            point = point.next;
        }
        if (flag) {
            throw new DuplicateModelNameException(title);
        } else {
            Model addModel = new Model(title, price);
            addModel.next = head.next;
            addModel.prev = head;
            head.next.prev = addModel;
            head.next = addModel;
            size++;
        }
    }

    public void removeModel(String title) throws NoSuchModelNameException {
        Model point = head.next;
        while (point != head) {
            if (point.getTitle().equals(title)) {
                point.prev.next = point.next;
                point.next.prev = point.prev;
                size--;
                return;
            }
            point = point.next;
        }
        throw new NoSuchModelNameException(title);
    }

    public int sizeModel() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public Bike clone() throws CloneNotSupportedException {
        Bike cloneBike = (Bike) super.clone();
        cloneBike.head = new Model();
        Model current = head.next;
        Model cloneCurrent = cloneBike.head;
        for (int i = 0; i < size; i++) {
            cloneCurrent.next = new Model(current.getTitle(), current.getPrice());
            cloneCurrent.next.prev = cloneCurrent;
            cloneCurrent = cloneCurrent.next;
            current = current.next;
        }
        cloneCurrent.next = cloneBike.head;
        cloneBike.head.prev = cloneCurrent;
        return cloneBike;
    }
}
