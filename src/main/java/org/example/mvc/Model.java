package org.example.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private List<Double> xValues;
    private List<Double> yValues;

    public Model() {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
    }

    public void addData(double x) {
        xValues.add(x);
        yValues.add(calculateY(x));
    }

    public void editData(int index, double newX) {
        xValues.set(index, newX);
        yValues.set(index, calculateY(newX));
    }

    public void removeData(int index) {
        xValues.remove(index);
        yValues.remove(index);
    }

    private double calculateY(double x) {
        return Math.log(x);
    }

    public List<Double> getXValues() {
        return xValues;
    }

    public List<Double> getYValues() {
        return yValues;
    }
}
