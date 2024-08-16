package org.example.factoryMethod;

import org.example.factoryMethod.exception.DuplicateModelNameException;

public class StaticMethods {
    private static TransportFactory factory = new AutoFactory();

    public static void setTransportFactory(TransportFactory transportFactory){
        factory = transportFactory;
    }

    public static Transport createInstance(String mark, int size) throws DuplicateModelNameException {
        return factory.createInstance(mark,size);
    }

    public static <T extends Transport> double arithmeticMean(T transport){
        double mean = 0;
        for (int i = 0; i < transport.returnAllPrice().length; i++){
            mean += transport.returnAllPrice()[i];
        }
        return mean/transport.returnAllPrice().length;
    }
    public static <T extends Transport> void allModelAndPrice(T transport){
        for (int i = 0; i < transport.sizeModel(); i++){
            System.out.println(transport.getAllTitle()[i] + " - " + transport.returnAllPrice()[i]);
        }
    }
    public static Transport synchronizedTransport(Transport transport){
        return new Decorator(transport);
    }

}
