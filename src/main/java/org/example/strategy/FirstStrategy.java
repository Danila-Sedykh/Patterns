package org.example.strategy;

import java.io.*;
import java.util.Arrays;

public class FirstStrategy implements Strategy{

    @Override
    public void countInteger(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(String.valueOf(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int count[] = (int[]) objectInputStream.readObject();

        Arrays.sort(count);

        int countInd = 1;
        int countElem = count[0];

        for (int i = 1; i < count.length; i++){
            if(count[i] == countElem){
                countInd++;
            }else {
                System.out.println(countElem + " : " + countInd);
                countElem = count[i];
                countInd = 1;
            }
        }
        System.out.println(countElem + " : " + countInd);

    }
}
