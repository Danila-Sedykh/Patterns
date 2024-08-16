package org.example.facade;

import javax.swing.*;

import static org.example.facade.MyComponent.jFrameTest;

public class Main{
    public static void main(String[] args){
        JFrame jFrame = jFrameTest();
        jFrame.add(new MyComponent());
        jFrame.add(new Facade());
        jFrame.setVisible(true);
    }

}
