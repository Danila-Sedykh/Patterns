package org.example.adapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class Adapter {
    public byte[] adapterArrayString(String[] arr) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes;
        for (int i = 0 ; i < arr.length; i++) {
            bytes = arr[i].getBytes();
            outputStream.write(bytes);
        }
        return outputStream.toByteArray();
    }

    public String toString(byte[] bytes) {
        return new String(bytes, Charset.defaultCharset());
    }
}
