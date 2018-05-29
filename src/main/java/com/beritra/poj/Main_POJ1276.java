package com.beritra.poj;

import java.util.Scanner;

public class Main_POJ1276 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int num = scanner.nextInt();
        int[] n = new int[num];
        int[] w = new int[num];
        for (int i = 0; i < num; i++) {
            n[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        new Main_POJ1276().dp(n, w, total);
    }

    private int dp(int[] n, int[] w, int total) {
        int result = 0;
        int[][] record = new int[n.length][total + 1];
        record[0][0] = 1;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (i > 0 && j - w[i] >= 0)
                    record[i][j] += record[i - 1][j - w[i]];
            }
        }
        return result;
    }
}
