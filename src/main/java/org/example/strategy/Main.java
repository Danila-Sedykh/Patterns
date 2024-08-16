package org.example.strategy;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args.length == 0) {
            System.out.println("Нужный файл не найден");
            return;
        }

        int[] array = {1,5,4,4,3,4,3,4,4,7,3,5,1,2,3,7,7};

        String fileName = args[0];

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(array);
        objectOutputStream.close();
        fileOutputStream.close();


        Strategy strategy = new FirstStrategy();
        strategy.countInteger(fileName);

        Strategy strategy1 = new SecondStrategy();
        strategy1.countInteger(fileName);

    }

}
