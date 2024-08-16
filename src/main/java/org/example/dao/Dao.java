package org.example.dao;

import org.example.factoryMethod.Transport;

public interface Dao {
    public void saveTransport(Transport transport);
    public Transport readTransport();
}
