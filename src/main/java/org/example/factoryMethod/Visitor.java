package org.example.factoryMethod;

import org.example.templateMethod.Ball;

public interface Visitor {
    void visit(Car car);
    void visit(Bike bike);
}
