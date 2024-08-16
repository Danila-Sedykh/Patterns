package org.example.dao;

import org.example.factoryMethod.StaticMethods;
import org.example.factoryMethod.Transport;
import org.example.factoryMethod.TransportFactory;
import org.example.factoryMethod.exception.DuplicateModelNameException;
import org.example.factoryMethod.exception.ModelPriceOutOfBoundsException;

import java.io.*;
import java.util.Arrays;


public class TextDao implements Dao{
    private String fileName;

    public TextDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveTransport(Transport transport) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(transport.getMark());
            writer.println(transport.sizeModel());
            writer.println(Arrays.toString(transport.getAllTitle()));
            writer.println(Arrays.toString(transport.returnAllPrice()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transport readTransport() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String mark = reader.readLine();
            int sizeMark = Integer.parseInt(reader.readLine());

            Transport car = StaticMethods.createInstance(mark, sizeMark);
            String allTitle = reader.readLine();
            String allPrice = reader.readLine();

            String[] partsTitle = allTitle.split(", ");
            String[] partsPrice = allPrice.split(", ");

            /*for (int i = 0; i < sizeMark; i++) {


                String modelTitle = partsTitle[i];
                double modelPrice = Double.parseDouble(partsPrice[i].replaceAll("\\[|\\]", ""));
                car.addModel(modelTitle, modelPrice);
            }*/
            return car;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        } catch (NumberFormatException | DuplicateModelNameException | ModelPriceOutOfBoundsException e) {
            throw new RuntimeException("Error parsing file: " + fileName, e);
        }
    }
}
