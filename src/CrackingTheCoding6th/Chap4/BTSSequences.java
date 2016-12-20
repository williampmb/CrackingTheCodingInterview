/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author William
 */
public class BTSSequences {

    public static void main(String[] args) {
        int[] a = {5,3,7,2,1,6,8};
        List<String> bSTSequences = bSTSequences(a);
        for (String w1 : bSTSequences) {
            System.out.println(w1);
        }
    }

    static List<String> permutation(String str) {
        return permutation(str, "");
    }

    static List<String> permutation(String str, String prefix) {
        List<String> words = new ArrayList<String>();
        if (str.length() == 0) {
            words.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                words.addAll(permutation(rem, prefix + str.charAt(i)));
            }
        }
        return words;
    }

    public static List<String> bSTSequences(int[] array) {
        List<String> comb = new ArrayList<String>();
        int pos = 0, count = 0;
        List<String> tmp;

        while (pos < array.length) {
            tmp = new ArrayList<String>();
            List<String> c = comb(pos, (int) Math.pow(2, count), array);
            if (comb.isEmpty()) {
                comb = c;
            } else {
                for (String w : c) {
                    for (String w2 : comb) {
                        String c3 = w2 + w;
                        tmp.add(c3);
                    }
                }
                comb = tmp;
            }

            pos += Math.pow(2, count);
            count++;
        }
        return comb;
    }

    private static List<String> comb(int start, int numEle, int[] array) {
        String word = "";
        int count = 0;
        do {
            if (array.length < count + start) {
                break;
            }
            word += array[count+start];
            count++;
        } while (count < numEle);
      
        List<String> permutation = permutation(word);
        return permutation;
    }
}
