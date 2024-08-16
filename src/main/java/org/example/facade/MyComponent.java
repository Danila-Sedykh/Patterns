package org.example.facade;

import javax.swing.*;
import java.awt.*;


public class MyComponent extends JComponent{

    public static JFrame jFrameTest(){
        JFrame jFrame = new JFrame(){};
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 400, dimension.height/2 - 277, 960, 540);
        jFrame.setTitle("Светофор");

        return jFrame;
    }

}
