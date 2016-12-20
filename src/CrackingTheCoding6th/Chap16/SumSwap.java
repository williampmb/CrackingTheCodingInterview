/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author William
 */
public class SumSwap {

    public static void main(String[] args) {
//        int[] a = { 1, 2,4, 1, 1, 2};
//        int[] b = {3, 6, 3, 3};
//
//        int[] c = sumSwap(a, b);
//        if (c != null) {
//            System.out.println(c[0] + " " + c[1]);
//        }

    }

    public static int[] sumSwap(int[] s1, int[] s2) {
        if (s1.length == 0 || s2.length == 0) {
            return null;
        }
        int sum1 = 0, sum2 = 0, dif;
        Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();

        for (int i : s1) {
            sum1 += i;
        }

        for (int i : s2) {
            sum2 += i;
            m2.put(i, i);
        }

        if ((sum1 + sum2) % 2 != 0) {
            return null;
        }

        dif = (Math.abs(sum1 - sum2)) / 2;

        for (int a : s1) {
            if (sum1 > sum2) {
                if (m2.get(a - dif) != null) {
                    int b = m2.get(a - dif);
                    int[] res = {a, b};
                    return res;
                }
            } else if (sum1 < sum2) {
                if (m2.get(a + dif) != null) {
                    int b = m2.get(a + dif);
                    int[] res = {a, b};
                    return res;
                }
            }
        }
        return null;
    }
}
