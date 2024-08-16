package org.example.adapter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] test = {"ert", "dada", "qaz"};
        Adapter adapter = new Adapter();
        byte[] bytes = adapter.adapterArrayString(test);
        System.out.println(Arrays.toString(bytes));
        System.out.println(adapter.toString(bytes));
    }
}
