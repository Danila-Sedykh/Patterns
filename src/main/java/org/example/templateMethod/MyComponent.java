package org.example.templateMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyComponent extends JFrame {
    private List<Ball> balls = new ArrayList<>();
    private List<Square> squares = new ArrayList<>();
    private List<Star> stars = new ArrayList<>();
    public MyComponent() {
        setTitle(" '_' ");
        setSize(316,275);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                for (Ball ball : balls){
                    ball.draw(g,ball.getX(), ball.getY());
                }
                for (Square square : squares){
                    square.draw(g,square.getX(), square.getY());
                }
                for (Star star : stars){
                    star.draw(g,star.getX(), star.getY());
                }

            }
        };

        add(panel);
        setVisible(true);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball ball = new Ball(10,10,1,1);
                balls.add(ball);
                ball.animate(panel);
            }
        });
        JButton squareButton = new JButton("Square");
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Square square = new Square(10,10,1,1);
                squares.add(square);
                square.animate(panel);
            }
        });
        JButton starButton = new JButton("Star");
        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Star star = new Star(10,10,1,1);
                stars.add(star);
                star.animate(panel);
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(starButton);
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);
        
    }
}
