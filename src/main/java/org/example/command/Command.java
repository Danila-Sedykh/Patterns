package org.example.command;

import org.example.factoryMethod.Car;

import java.io.FileWriter;
import java.io.IOException;

public interface Command{
    public void printTransport(Car car, FileWriter fileWriter) throws IOException;

}
