package org.example.chainOfResponsibility;

import org.example.factoryMethod.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class Column implements ChainOfResponsibility{
    private ChainOfResponsibility chainOfResponsibility;

    @Override
    public void printTransport(Transport transport, FileWriter fileWriter) throws IOException {
        if (transport.sizeModel() > 3) {
            for (String s : transport.getAllTitle()) {
                fileWriter.write(s + ";");
                fileWriter.write("\n");
            }

        } else {
            chainOfResponsibility.printTransport(transport,fileWriter);
        }

    }

    @Override
    public void chainMethod(ChainOfResponsibility chainOfResponsibility) {
        this.chainOfResponsibility = chainOfResponsibility;
    }
}
