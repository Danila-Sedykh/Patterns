package org.example.factoryMethod;

import org.example.factoryMethod.exception.DuplicateModelNameException;

public interface TransportFactory {
    public Transport createInstance(String mark, int size) throws DuplicateModelNameException;
}
