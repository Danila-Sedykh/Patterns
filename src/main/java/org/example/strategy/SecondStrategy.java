package org.example.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class SecondStrategy implements Strategy{

    @Override
    public void countInteger(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(String.valueOf(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int count[] = (int[]) objectInputStream.readObject();

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : count) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Элемент " + entry.getKey() + " встречается " + entry.getValue() + " раз(а)");
        }
    }
}
