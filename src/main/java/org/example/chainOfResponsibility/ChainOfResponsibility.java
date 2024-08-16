package org.example.chainOfResponsibility;

import org.example.factoryMethod.Transport;

import java.io.FileWriter;
import java.io.IOException;

public interface ChainOfResponsibility {
    void printTransport(Transport transport, FileWriter fileWriter) throws IOException;
    void chainMethod(ChainOfResponsibility chainOfResponsibility);
}
