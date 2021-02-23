package ru.geekbrains;

import java.io.Serializable;

public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }
    public String[] getHeader() { return header; }
    public int[][] getData() { return data; }
}
