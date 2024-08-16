package org.example.mvc;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.addData(1);
        model.addData(2);
        model.addData(3);
        model.addData(4);
        model.addData(5);
        Controller controller = new Controller(model);
        View view = new View(controller);
        view.setVisible(true);
    }
}
