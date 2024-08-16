package org.example.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyComponent extends JFrame{
    private Eye leftEye = new Eye();
    private Eye rightEye = new Eye();
    private Nose nose = new Nose();
    private Mouth mouth = new Mouth();
    public MyComponent() {

        setTitle("Face");
        setSize(316, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Face face = new Face();
        face.registerObserver(leftEye);
        face.registerObserver(rightEye);
        face.registerObserver(nose);
        face.registerObserver(mouth);

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Image image = new ImageIcon("img/fone.jpg").getImage();
                g2.drawImage(image, 0, 0, null);

                drawLeftEye(g);
                drawRightEye(g);

                drawNose(g, nose.getColor());

                mouth.draw(g);


            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (isInLeftEye(x, y)) {
                    face.notifyObservers(leftEye);
                }else if (isInRightEye(x, y)){
                    face.notifyObservers(rightEye);
                }else if (isInNose(x, y)) {
                    face.notifyObservers(nose);
                } else if (isInMouth(x, y)) {
                    face.notifyObservers(mouth);
                }
                repaint();
            }

            private boolean isInLeftEye(int x, int y) {
                int eyeLeftX = 40;
                int eyeLeftY = 70;
                int eyeWidth = 77;
                int eyeHeight = 74;

                return x >= eyeLeftX && x <= eyeLeftX + eyeWidth &&
                        y >= eyeLeftY && y <= eyeLeftY + eyeHeight;
            }

            private boolean isInRightEye(int x, int y) {
                int eyeRightX = 259;
                int eyeRightY = 70;
                int eyeWidth = 77;
                int eyeHeight = 74;

                return x <= eyeRightX && x >= eyeRightX - eyeWidth &&
                        y >= eyeRightY && y <= eyeRightY + eyeHeight;
            }

            private boolean isInNose(int x, int y) {
                int eyeCenterX = 150;
                int eyeCenterY = 150;
                int eyeRadius = 16;

                int distanceSquared = (x - eyeCenterX) * (x - eyeCenterX) + (y - eyeCenterY) * (y - eyeCenterY);
                return distanceSquared <= eyeRadius * eyeRadius;
            }

            private boolean isInMouth(int x, int y) {
                int mouthX = 75;
                int mouthY = 180;
                int mouthWidth = 150;
                int mouthHeight = 70;

                return x >= mouthX && x <= mouthX + mouthWidth &&
                        y >= mouthY && y <= mouthY + mouthHeight;
            }

        });


        add(panel);
    }
    private void drawLeftEye(Graphics g){
        g.drawImage(leftEye.getImageEye(),40,70,null);
    }
    private void drawRightEye(Graphics g){
        g.drawImage(rightEye.getImageEye(),189,70,null);
    }

    private void drawNose(Graphics g, Color color) {
        g.setColor(color);
        int[] xPoints = {152, 144, 160};
        int[] yPoints = {142, 158, 158};
        g.fillPolygon(xPoints, yPoints, 3);
    }

}
