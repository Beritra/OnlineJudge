package com.beritra.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Package {

    public static void main(String[] args) {
//        new Package().oneZeroPackage(new int[]{3, 3, 5, 7, 8}, new int[]{6, 7, 12, 20, 30}, 80);
//        new Package().completePackage(new int[]{3, 3, 5, 7, 8}, new int[]{6, 7, 12, 20, 30}, 78);
        new Package().completePackageToOneZero(new int[]{3, 3, 5, 7, 8}, new int[]{6, 7, 12, 20, 30}, 78);

    }

    private void oneZeroPackage(int[] c, int[] w, int v) {
        int[] record = new int[v + 1];
        //如果不要求正好填满背包，那么要这样初始化
//        for (int i = 1; i < record.length; i++) {
//            record[i] = -99999;
//        }
        for (int i = 1; i <= c.length; i++) {
            int bound = max(v - sum(c, i - 1), c[i - 1]);
            for (int j = v; j >= bound; j--) {
                record[j] = max(record[j], record[j - c[i - 1]] + w[i - 1]);
            }
        }
        System.out.println(record[v]);
    }

    private void completePackage(int[] c, int[] w, int v) {
        int[] record = new int[v + 1];
        for (int i = 1; i <= c.length; i++) {
            for (int j = v; j >= c[i - 1]; j--) {
                for (int k = 0; k <= j / c[i - 1]; k++) {
                    record[j] = max(record[j], record[j - k * c[i - 1]] + k * w[i - 1]);
                }
            }
        }
        System.out.println(record[v]);
    }

    private void completePackageToOneZero(int[] c, int[] w, int v) {
        List<Integer> cList = new ArrayList<>();
        List<Integer> wList = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j <= v/c[i]; j++) {
                cList.add(c[i]);
                wList.add(w[i]);
            }
        }
        completePackage(Arrays.stream(cList.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray(), Arrays.stream(wList.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray(), v);
    }

    public void mutilePackage() {

    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int sum(int[] a, int start) {
        int result = 0;
        for (int i = start; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }
}
