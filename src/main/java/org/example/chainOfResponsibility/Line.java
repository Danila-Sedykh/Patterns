package org.example.chainOfResponsibility;

import org.example.factoryMethod.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class Line implements ChainOfResponsibility {
    private ChainOfResponsibility chainOfResponsibility;

    @Override
    public void printTransport(Transport transport, FileWriter fileWriter) throws IOException {
        if (transport.sizeModel() <= 3) {
            StringBuilder sb = new StringBuilder();
            for (String s : transport.getAllTitle()) {
                sb.append(s).append("; ");
            }
            fileWriter.write(sb.toString());
            fileWriter.write("\n");
        } else {
            chainOfResponsibility.printTransport(transport,fileWriter);
        }
    }

    @Override
    public void chainMethod(ChainOfResponsibility chainOfResponsibility) {
        this.chainOfResponsibility = chainOfResponsibility;
    }
}
