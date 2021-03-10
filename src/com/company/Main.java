package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        FunctionsNew arrayNew = new FunctionsNew();

        ArrayList<String> funkce = new ArrayList<>();
        int count = 0;
        String countFix = "";


        try {
            BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
            BufferedWriter bwCount = new BufferedWriter(new FileWriter("count.txt"));
            BufferedWriter bwDistinct = new BufferedWriter(new FileWriter("count_distinct.txt"));

            while ((arrayNew.function = br.readLine()) != null) {
                funkce.add(arrayNew.function);
                count++;
            }
            countFix = countFix + count;

            bwCount.write(countFix);
            Collections.sort(funkce);


            for (int j = 0; j < funkce.size(); j++) {
                for (int k = j + 1; k < funkce.size(); k++) {
                    if (funkce.get(k).equals(funkce.get(j))) {
                        funkce.remove(funkce.get(k));
                    }
                }
            }

            for (int j = 0; j < funkce.size(); j++) {
                for (int k = j + 1; k < funkce.size(); k++) {
                    if (funkce.get(k).equals(funkce.get(j))) {
                        funkce.remove(funkce.get(k));
                    }
                }
            }

            for (int i = 0; i < funkce.size(); i++) {
                bwDistinct.write(funkce.get(i));
                bwDistinct.newLine();
            }

            bwCount.close();
            bwDistinct.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
