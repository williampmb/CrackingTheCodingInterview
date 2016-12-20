/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author William
 */
public class MatchingWords {

    static Map<Integer, char[]> db = new Hashtable<Integer, char[]>();

    public static void main(String[] args) {
        insertValuesInHash();
      //  List<String> matchWords = matchWords(8733);
        List<String> matchWords = matchWords(5455);
        for(String w : matchWords){
            System.out.println(w);
        }
    }

    private static void insertValuesInHash() {
        char[] d = {'a', 'b', 'c'};
        db.put(2, d);
        char[] d1 = {'d', 'e', 'f'};
        db.put(3, d1);
        char[] d2 = {'g', 'h', 'i'};
        db.put(4, d2);
        char[] d3 = {'j', 'k', 'l'};
        db.put(5, d3);
        char[] d4 = {'m', 'n', 'o'};
        db.put(6, d4);
        char[] d5 = {'p', 'q', 'r', 's'};
        db.put(7, d5);
        char[] d6 = {'t', 'u', 'v'};
        db.put(8, d6);
        char[] d7 = {'w', 'x', 'y', 'z'};
        db.put(9, d7);
    }

    public static List<String> matchWords(int num) {
        if (num < 2) {
            return null;
        }
        List<String> words = new ArrayList<String>();
        Dictionary dic = Dictionary.build("tree used utero kill");
        words.addAll(matchWords("", num, dic));
        return words;
    }

    private static List<String> matchWords(String matched, int num, Dictionary dic) {
        List<String> words = new ArrayList<String>();
        if (dic.data >0) {
            words.add(matched);
        }
        char charAt = String.valueOf(num).charAt(0);
        if (charAt == '1' || charAt == '0') {
            return words;
        }
        int map = Integer.valueOf(""+charAt);
        char[] let = db.get(map);

        for (char c : let) {
            if (dic.child[((int) c) - 97] != null) {
                String substring = String.valueOf(num).substring(1);
                if (!substring.equals("")) {
                    words.addAll(matchWords(matched + c, Integer.valueOf(substring), dic.child[((int) c) - 97]));
                } else {
                    words.addAll(matchWords(matched + c, 0, dic.child[((int) c) - 97]));
                }
            }
        }
        return words;
    }
}
