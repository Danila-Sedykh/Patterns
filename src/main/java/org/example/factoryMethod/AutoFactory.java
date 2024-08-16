package org.example.factoryMethod;

public class AutoFactory implements TransportFactory{

    @Override
    public Transport createInstance(String mark, int size) {
        return new Car(mark,size);
    }
}
