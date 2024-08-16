package org.example.proxy;

public class Main {
    public static void main(String[] args) {
        ProxyClient proxyClient = new ProxyClient();
        double result = proxyClient.multiply(3.5, 2.5);
        double result1 = proxyClient.multiply(60, 3);
        double result2 = proxyClient.multiply(8.11, 4.88);
        System.out.println("Результат умножения: " + result);
        System.out.println("Результат умножения: " + result1);
        System.out.println("Результат умножения: " + result2);
    }
}
