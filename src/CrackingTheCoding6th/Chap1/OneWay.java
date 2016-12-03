/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap1;

import static CrackingTheCoding6th.Chap1.IsUnique.hasUniqueChar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author William 1.5 - There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero
 * edits) away.
 */
public class OneWay {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/CrackingTheCoding6th/Chap1/input.txt"));

        String input = br.readLine();
        int count = 0;
        while (input != null && !input.equals("")) {
            count++;
            String[] tk = input.split(" ");

            boolean result = oneWay(tk[0], tk[1]);

            System.out.println(count + " - " + result);
            input = br.readLine();
        }
    }

    public static boolean oneWay(String s1, String s2) {
        boolean result;
        if (s1.length() == s2.length()) {
            result = oneReplace(s1, s2);
        } else if (s1.length() == s2.length() + 1) {
            result = oneInsert(s2, s1);
        } else if (s1.length() == s2.length() - 1) {
            result = oneInsert(s1, s2);
        } else {
            result = false;
        }
        return result;
    }

    private static boolean oneReplace(String s1, String s2) {
        boolean edited = false;
        int pos = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(pos)) {
                if (edited) {
                    return false;
                }
                edited = true;
            }
            pos++;
        }
        return true;
    }

    private static boolean oneInsert(String s1, String s2) {
        boolean insert = false;
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < s1.length() && pos2 < s2.length()) {
            if (s1.charAt(pos1) != s2.charAt(pos2)) {
                if (insert) {
                    return false;
                }
                insert = true;
                pos2++;
            } else {
                pos1++;
                pos2++;
            }
        }
        return true;
    }
}
