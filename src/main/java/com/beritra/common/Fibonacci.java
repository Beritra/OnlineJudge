package com.beritra.common;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    Map<Integer, Long> fi = new HashMap();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new Fibonacci().recursion(50));
//        System.out.println(new Fibonacci().recursionEnhance(1000));
        System.out.println(new Fibonacci().dp(1000));

        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    private long recursionEnhance(int a) {
        if (fi.containsKey(a)) {
            return fi.get(a);
        } else {
            Long result = a == 0 ? 0 : (a == 1 ? 1 : recursionEnhance(a - 2) + recursionEnhance(a - 1));
            fi.put(a, result);
            return result;
        }
    }

    private long recursion(int a) {
        return a == 0 ? 0 : (a == 1 ? 1 : recursion(a - 2) + recursion(a - 1));
    }

    private long dp(int a) {
        long[] record = new long[a];
        record[0] = 1;
        record[1] = 1;
        for (int i = 2; i < a; i++) {
            record[i] = record[i - 1] + record[i - 2];
        }
        return record[a - 1];
    }
}
