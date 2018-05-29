package com.beritra.poj;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main_POJ1276 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNextInt()) {
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

    }

    private void dp(int[] n, int[] w, int total) {
        int result = 0;
        if (n.length == 0 || total == 0) {
            System.out.print("\n" + result);
            return;
        }
        int[][] record = new int[n.length + 1][total + 1];
        for (int i = 0; i < n.length; i++) {

            int a = 0;
            for (int j = 0; j <= total; j++) {
                for (int k = 0; k <= n[i]; k++) {
                    if (j - k * w[i] >= 0) {
                        if (i > 0) {
                            int b = record[i - 1][j - k * w[i]] + k * w[i];
                            a = (a >= b) ? a : b;
                        }
                    }


                }
            }
            record[i + 1][total] = a;
        }
        result = record[n.length][total];
        System.out.print(String.valueOf("\n" + result));
    }
}
