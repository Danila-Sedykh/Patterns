package org.example.factoryMethod.exception;

public class ModelPriceOutOfBoundsException extends RuntimeException{
    public ModelPriceOutOfBoundsException(){
        System.out.println("Цена введена неправильно");
    }
}
