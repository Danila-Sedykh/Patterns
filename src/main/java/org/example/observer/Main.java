package org.example.observer;

import org.example.facade.Facade;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new MyComponent();
        jFrame.setVisible(true);
    }
}
