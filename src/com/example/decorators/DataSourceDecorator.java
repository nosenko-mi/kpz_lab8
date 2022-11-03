package com.example.decorators;

import com.example.datasource.DataSource;

public class DataSourceDecorator implements DataSource {
    private DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        System.out.println("[WRITE]");

        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        System.out.println("[READ]");

        return wrapper.readData();
    }
}