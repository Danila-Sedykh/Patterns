package org.example.factoryMethod;

import org.example.factoryMethod.Bike;
import org.example.factoryMethod.Transport;
import org.example.factoryMethod.TransportFactory;
import org.example.factoryMethod.exception.DuplicateModelNameException;

public class BikeFactory implements TransportFactory {
    @Override
    public Transport createInstance(String mark, int size) throws DuplicateModelNameException {
        return new Bike(mark,size);
    }
}
