package org.example.facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facade extends JPanel{
    private Car car;
    private TrafficLight trafficLight;
    private ImageIcon background;
    private Image trafficLightIcon;


    public Facade() {

        car = new Car(-250, 250, 5);
        trafficLight = new TrafficLight(437, 167, 437, 210, 437, 250, 2000); // Интервал переключения цветов: 2.6 секунды

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move();
                if (car.getX() >= trafficLight.getxRed() - 350 && car.getX() <= trafficLight.getxRed()-100) {
                    if (trafficLight.getColor() == Color.RED) {
                        car = new Car(car.getX(), 250, 0);
                    } else if (trafficLight.getColor() == Color.GREEN) {
                        car = new Car(car.getX(), 250, 5);
                    }
                }
                repaint();
            }
        });

        timer.start();

    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Image image = new ImageIcon("img/road.jpg").getImage();
        g2.drawImage(image, 0, 0, null);
        Image image1 = new ImageIcon("img/trafficLight3.png").getImage();
        g2.drawImage(image1, 200, 130, null);
        trafficLight.draw(g);
        car.draw(g2);
    }

}
