package org.example.proxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ProxyClient {
    public double multiply(double num1, double num2) {
        try {
            Socket socket = new Socket("localhost", 5000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeDouble(num1);
            out.writeDouble(num2);
            out.flush();
            return in.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
            return Double.NaN; // возвращаем NaN в случае ошибки
        }
    }
}
