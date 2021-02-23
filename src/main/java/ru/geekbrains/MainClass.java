package ru.geekbrains;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MainClass {
    public static void writeFile(AppData vallist) {
        try (PrintWriter out = new PrintWriter("n_values.csv")) {
            for (String v : vallist.getHeader()) out.print(v + ";");
            out.println();

            int[][] vallistData = vallist.getData();
            for (int i = 0; i < vallistData.length; i++) {
                for (int j = 0; j < vallistData[i].length; j++) {
                    out.print(vallistData[i][j] + ";");
                }
                out.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static AppData readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("values.csv"));


                List<IntStream> dataArr = new ArrayList<>();
        String[] dataHeader = in.readLine().split(";");
        String readLine = null;
        while ((readLine = in.readLine()) != null) {
            List<Integer> LineArr = new ArrayList<>();
            String[] tokens = readLine.split(";");
            for (int i = 0; i < tokens.length; i++) {
                LineArr.add(Integer.parseInt(tokens[i]));
            }
            dataArr.add(Arrays.stream(LineArr.stream().mapToInt(i -> 1).toArray()));
        }
        AppData vallist2 = new AppData(dataHeader, dataArr.toArray(new int[0][]));
        return vallist2;
    }

    public static void main(String[] args) throws IOException {
        String[] header = {"val1", "val2", "val3"};
        int[][] data = {{100, 200, 300}, {400, 500, 600}, {700, 800, 900}};
        AppData vallist = new AppData(header, data);
        writeFile(vallist);
        try {
            AppData readedCsv = readFile();
            for (String v : readedCsv.getHeader()) {
                System.out.print(v + ";");
            }
            System.out.println();
            int[][] readedCsvData = readedCsv.getData();
            for (int i = 0; i < readedCsvData[i].length; i++) {
                for (int j = 0; j < readedCsvData[i].length; j++) {
                    System.out.print(readedCsvData[i][j] + ";");
                }
                System.out.print("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
