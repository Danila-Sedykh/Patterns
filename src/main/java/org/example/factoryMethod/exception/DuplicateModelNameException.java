package org.example.factoryMethod.exception;

public class DuplicateModelNameException extends Exception{
    public DuplicateModelNameException(String title){
        super("Модель < " + title + " > уже существует");
    }
}
