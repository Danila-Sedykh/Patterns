package org.example.factoryMethod;

import org.example.chainOfResponsibility.ChainOfResponsibility;
import org.example.command.Column;
import org.example.command.Command;
import org.example.command.Line;
import org.example.dao.Dao;
import org.example.dao.SerializDao;
import org.example.dao.TextDao;
import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.NoSuchModelNameException;
//import sun.tools.jstat.ColumnFormat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException, IOException {
        /*Car car = new Car("123", 6);
        System.out.println(Arrays.toString(car.getAllTitle()));
        car.setModelTitle("2102", "2106");
        System.out.println(Arrays.toString(car.getAllTitle()));
        System.out.println(car.getModelPrice("2104"));
        car.setModelPrice("2101", 321);
        //car.addModel("dwda", -1);*/


       /* Bike bike = new Bike("123", 6);
        System.out.println(Arrays.toString(bike.getAllTitle()));
        bike.setModelTitle("Z-600", "Z-200");
        System.out.println(Arrays.toString(bike.getAllTitle()));
        bike.addModel("opoo", 123);
        //bike.addModel("opoo", 123);
        System.out.println(Arrays.toString(bike.getAllTitle()));
        bike.removeModel("opoo");
        System.out.println(Arrays.toString(bike.getAllTitle()));*/



        /*Transport auto = StaticMethods.createInstance("Лада", 6);
        StaticMethods.allModelAndPrice(auto);
        System.out.println(StaticMethods.arithmeticMean(auto));
        System.out.println(auto.getClass());

        System.out.println("----> " + StaticMethods.synchronizedTransport(auto));
        Transport decor = StaticMethods.synchronizedTransport(auto);
        decor.setModelTitle("2101","////");
        StaticMethods.allModelAndPrice(decor);*/



        /*StaticMethods.setTransportFactory(new BikeFactory());
        Transport moto = StaticMethods.createInstance("Kawasaki", 3);
        StaticMethods.allModelAndPrice(moto);
        System.out.println(StaticMethods.arithmeticMean(moto));
        System.out.println(moto.getClass());

        Transport decorMoto = StaticMethods.synchronizedTransport(moto);
        System.out.println("----> " + decorMoto);
        decorMoto.setModelTitle("Z-200","****");
        StaticMethods.allModelAndPrice(decorMoto);*/


        /*Car car1 = new Car("CAR", 6);
        Car car2;
        car2 = car1.clone();
        System.out.println(Arrays.toString(car1.getAllTitle()));
        System.out.println(Arrays.toString(car2.getAllTitle()));
        System.out.println(car1.getClass());
        System.out.println(car2.getClass());
        //car2.addModel("12354", 1555);
        car2.setModelTitle("2104","8888");
        System.out.println(Arrays.toString(car1.getAllTitle()));
        System.out.println(Arrays.toString(car2.getAllTitle()));*/

        /*Bike bike1 = new Bike("BIKE", 6);
        Bike bike2;
        bike2 = bike1.clone();
        System.out.println(Arrays.toString(bike1.getAllTitle()));
        System.out.println(Arrays.toString(bike2.getAllTitle()));
        System.out.println(bike1.getClass());
        System.out.println(bike2.getClass());
        bike2.setModelTitle("Z-200", "9999");
        System.out.println(Arrays.toString(bike1.getAllTitle()));
        System.out.println(Arrays.toString(bike2.getAllTitle()));*/

        /*Car car12 = new Car("Car12",4);
        Bike bike12 = new Bike("Bike12",4);*/

// - 1  ChainMethod
        /*Line line = new Line();
        Column column = new Column();

        line.chainMethod(column);
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("src/main/java/org/example/chainOfResponsibility/output.txt");
            Transport auto = StaticMethods.createInstance("Лада", 4);
            line.printTransport(auto,fileWriter);

            StaticMethods.setTransportFactory(new BikeFactory());
            Transport moto = StaticMethods.createInstance("Kawasaki", 2);
            line.printTransport(moto,fileWriter);
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
// - 2 Command
        /*FileWriter fileWriter;
        Car car = new Car("Lada",4);

        try {
            fileWriter = new FileWriter("src/main/java/org/example/command/output.txt");

            car.setPrintCommand(new Column());
            car.print(car, fileWriter);

            car.setPrintCommand(new Line());
            car.print(car, fileWriter);

            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
// - 3 Iterator
        Car car = new Car("Lada", 4);
        Iterator iterator = car.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
// - 4 Memento
        /*Car car = new Car("Lada", 4);
        Car.Memento memento = car.createMemento();
        System.out.println(Arrays.toString(car.getAllTitle()));

        car.setModelTitle("2101", "0000");
        car.addModel("Test", 7777);
        System.out.println(Arrays.toString(car.getAllTitle()));

        car.setMemento(memento);
        System.out.println(Arrays.toString(car.getAllTitle()));*/

// - 9 Visitor

       /* StaticMethods.setTransportFactory(new BikeFactory());
        Transport moto = StaticMethods.createInstance("Kawasaki", 3);
        moto.accept(new PrintVisitor());

        StaticMethods.setTransportFactory(new AutoFactory());
        Transport car = StaticMethods.createInstance("ВАЗ", 3);
        car.accept(new PrintVisitor());

        Transport decorMoto = StaticMethods.synchronizedTransport(moto);
        decorMoto.accept(new PrintVisitor());*/

// --DAO

        Car car1 = new Car("ВАЗ", 5);
        Dao serializDao = new SerializDao("serializ.txt");
        Dao textDao = new TextDao("text.txt");
        serializDao.saveTransport(car1);
        textDao.saveTransport(car1);

        System.out.println("Serializ");
        System.out.println(serializDao.readTransport().getMark());
        System.out.println(serializDao.readTransport().sizeModel());
        System.out.println(Arrays.toString(serializDao.readTransport().getAllTitle()));
        System.out.println(Arrays.toString(serializDao.readTransport().returnAllPrice()) + "\n");

        System.out.println("Text");
        System.out.println(textDao.readTransport().getMark());
        System.out.println(textDao.readTransport().sizeModel());
        System.out.println(Arrays.toString(textDao.readTransport().getAllTitle()));
        System.out.println(Arrays.toString(textDao.readTransport().returnAllPrice()));






    }
}