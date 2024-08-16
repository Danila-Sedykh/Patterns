package org.example.factoryMethod;

public class PrintVisitor implements Visitor{
    @Override
    public void visit(Car car) {
        for(Car.Model car1 : car.getModel()){
            System.out.print(car1.getTitle() + " - " + car1.getTitle() + "; ");
        }
        System.out.println("");
    }

    @Override
    public void visit(Bike bike) {
        for(int i = 0; i < bike.sizeModel(); i++){
            System.out.println(bike.getAllTitle()[i] + " + " + bike.returnAllPrice()[i] + ";");
        }
    }

}
