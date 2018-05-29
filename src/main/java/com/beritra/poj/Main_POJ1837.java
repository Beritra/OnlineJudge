package com.beritra.poj;

import java.io.BufferedInputStream;
import java.util.*;

public class Main_POJ1837 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        String s = in.nextLine();
//        String[] hook = in.nextLine().split(" ");
//        Integer[] hooks = new Integer[hook.length];
//        String[] weight = in.nextLine().split(" ");
//        Integer[] weights = new Integer[weight.length];
//        for (int i = 0; i < hook.length; i++) {
//            hooks[i] = Integer.parseInt(hook[i]);
//        }
//        for (int i = 0; i < weight.length; i++) {
//            weights[i] = Integer.parseInt(weight[i]);
//        }
//        System.out.println(new POJ1837().test(hooks, weights, 0));
//
//    }
//
//
//    public int test(Integer[] hook, Integer[] weight, int sum) {
//        int result = 0;
//        if (weight.length == 1) {
//            for (int aHook : hook) {
//                if (aHook * weight[0] == sum) {
//                    result += 1;
//                } else {
//                    result+=0;
//                }
//            }
//        } else {
//            for (int i = 0; i < hook.length; i++) {
//                int s = sum + -1 * weight[weight.length - 1] * hook[i];
//                result += test(hook, Arrays.copyOf(weight, weight.length - 1), s);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int hookNum = in.nextInt();
        int weightsNum = in.nextInt();
        List<Integer> hooks = new ArrayList();
        List<Integer> weights = new ArrayList();
        for (int i = 0; i < hookNum; i++) {
            hooks.add(in.nextInt());
        }
        for (int i = 0; i < weightsNum; i++) {
            weights.add(in.nextInt());
        }
        System.out.println(new Main_POJ1837().test(hooks, weights, 0));
    }

    Map<Integer, Integer> map = new HashMap();


    private int test(List<Integer> hook, List<Integer> weight, int sum) {
        int result = 0;
        if (weight.size() == 1) {
            for (int aHook : hook) {
                if (aHook * weight.get(0) == sum) {
                    result += 1;
                } else {
                    result += 0;
                }
            }
        } else {
            for (int i = 0; i < hook.size(); i++) {
                int s = sum + -1 * weight.get(weight.size() - 1) * hook.get(i);
                List<Integer> newList = weight.subList(0, weight.size() - 1);
                int hash = newList.hashCode()*10000+s;
                if(map.containsKey(hash)){
                    result += map.get(hash);
                }else{
                    int ii=test(hook, newList, s);
                    map.put(hash, ii);
                    result += ii;
                }
            }
        }
        return result;
    }

}
