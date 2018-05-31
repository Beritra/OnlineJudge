package com.beritra.poj;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_POJ1276 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNextInt()) {
            int total = scanner.nextInt();
            int num = scanner.nextInt();
            List<Integer> n = new ArrayList();
            List<Integer> w = new ArrayList();
            for (int i = 0; i < num; i++) {
                n.add(scanner.nextInt());
                w.add(scanner.nextInt());
            }
            new Main_POJ1276().multiplePackage(n, w, total);
        }
    }

    //Time Limit Exceeded
    private void dp(int[] n, int[] w, int total) {
        int result = 0;
        if (n.length == 0 || total == 0) {
            System.out.print("\n" + result);
            return;
        }
        int[][] record = new int[n.length + 1][total + 1];

        for (int i = 1; i <= n.length; i++) {
            int[] num2 = new int[(int) Math.sqrt(n[i - 1]) + 1];

            for (int j = 0; j <= total; j++) {
                int a = 0;
                for (int k = 0; k <= n[i - 1]; k++) {
                    if (j - k * w[i - 1] >= 0) {
                        int b = record[i - 1][j - k * w[i - 1]] + k * w[i - 1];
                        a = (a >= b) ? a : b;
                        record[i][j] = a;
                    }
                }
            }
        }
        result = record[n.length][total];
        System.out.print(String.valueOf("\n" + result));
    }

    private void multiplePackage(List<Integer> n, List<Integer> w, int v) {
        if (n.size() == 0 || v == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> newW = new ArrayList();
        int min = w.get(0);
        for (int i = 0; i < n.size(); i++) {
            int k = 1;
            int amount = n.get(i);
            min = min > w.get(i) ? w.get(i) : min;
            while (k < amount) {
                newW.add(w.get(i) * k);
                amount -= k;
                k *= 2;
            }
            if (n.get(i) - k + 1 > 0) {
                newW.add(w.get(i) * amount);
            }
        }
        if (min > v) {
            System.out.println(0);
            return;
        }

        oneZeroPackage(newW, v);
    }


    private int max(int a, int b) {
        return a > b ? a : b;
    }


    private void oneZeroPackage(List<Integer> w, int v) {
        int[] record = new int[v + 1];
        record[0] = 1;
        for (int i = 1; i <= w.size(); i++) {
            for (int j = v; j - w.get(i - 1) >= 0; j--) {
                record[j] = max(record[j], record[j - w.get(i - 1)]);
            }
        }
        for (int i = v; i >= 0; i--) {
            if (record[i] == 1) {
                System.out.println(i);
                return;
            }
        }
    }

}
