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

    //Time Limit Exceeded
    private void dp(int[] n, int[] w, int total) {
        int result = 0;
        if (n.length == 0 || total == 0) {
            System.out.print("\n" + result);
            return;
        }
        int[][] record = new int[n.length + 1][total + 1];

        for (int i = 1; i <= n.length; i++) {
            int[] num2 = new int[(int)Math.sqrt(n[i - 1])+1];
//            for (int j = 0; j <= Math.sqrt(n[i - 1]); j++) {
//                if(n[i-1]-Math.pow(2,i)+1>0){
//                    num2[j] = Math.pow(2, i - 1);
//                }
//            }
//
            
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
}
