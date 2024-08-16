package org.example.factoryMethod.exception;

public class NoSuchModelNameException extends Exception{
    public NoSuchModelNameException(String title){
        super("Название модели < "+ title + " > не найденно =(");
    }
}
