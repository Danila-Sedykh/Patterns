package org.example.command;

import org.example.factoryMethod.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Line implements Command, Serializable {
    @Override
    public void printTransport(Car car, FileWriter fileWriter) throws IOException {
        for(String i : car.getAllTitle()){
            fileWriter.write(i + "; ");
        }

    }
}
