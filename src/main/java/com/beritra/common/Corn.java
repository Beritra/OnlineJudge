package com.beritra.common;

public class Corn {
    public static void main(String[] args) {
        for (int i = 0; i <= 300; i++) {
            System.out.println(new Corn().dp(i) + " " + i);

        }
    }

    private int dp(int number) {
        int[] record = new int[number + 1];
        int[] corns = {1, 3, 5};
        record[0] = 0;
        for (int i = 1; i <= number; i++) {
            int min = 9999;
            int minCorn = 1;
            for (int j = 0; j < corns.length; j++) {
                if (i >= corns[j] && min >= record[i - corns[j]]) {
                    min = record[i - corns[j]];
                    minCorn = corns[j];
                }
            }
            record[i] = record[i - minCorn] + 1;
        }
        return record[number];
    }


}
