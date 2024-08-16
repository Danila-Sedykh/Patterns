package org.example.state;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        StateTest stateTest = new StateTest();
        JFrame jFrame = new JFrame("State");
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(stateTest.getImage(), 100, 100, null);
                repaint();
            }
        };

        jFrame.add(jPanel);
        jFrame.setSize(300,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JButton buttonBreak = new JButton("Каникулы");
        jPanel.add(buttonBreak);
        buttonBreak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateTest.setState(new BreakState());
                stateTest.doAction();
            }
        });

        JButton buttonSemester = new JButton("Семестр");
        jPanel.add(buttonSemester);
        buttonSemester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateTest.setState(new SemesterState());
                stateTest.doAction();
            }
        });

        JButton buttonSession = new JButton("Сессия");
        jPanel.add(buttonSession);
        buttonSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateTest.setState(new SessionState());
                stateTest.doAction();
            }
        });

        jFrame.setVisible(true);

    }
}
