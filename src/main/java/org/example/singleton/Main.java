package org.example.singleton;


public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton.getProperties("password"));
        System.out.println(singleton.getProperties("login"));
        System.out.println(singleton.getProperties("gmail"));
        System.out.println(singleton);
        System.out.println(singleton1);

    }
}