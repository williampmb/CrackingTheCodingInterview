/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap1;

import static CrackingTheCoding6th.Chap1.CheckPermutation.permutation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author William 1.3 - Write a method to replace all spaces in a string with
 * '%20: You may assume that the string has sufficient space at the end to hold
 * the additional characters, and that you are given the "true" length of the
 * string.
 */
public class URLify {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/CrackingTheCoding6th/Chap1/input.txt"));

        String input = br.readLine();
        int count = 0;
        while (input != null && !input.equals("")) {
            count++;
            String[] tk = input.split("\\.");
            char[] str = tk[0].toCharArray();

            boolean result = urlLify(str, Integer.valueOf(tk[1]));

            System.out.println(count + " - " + result);
            print(str);

            input = br.readLine();
        }

    }

    public static boolean urlLify(char[] str, int size) {
        int pos = size - 1;
        int spaces = 0;
        int full = size;
        int i;
        if(pos > str.length-1){
            return false;
        }
        for (i = str.length - 1; i > -1; i--) {
            if (pos < 0) {
                return false;
            }
            if (str[pos] == ' ') {
                spaces++;
                if (str.length < full + 2 * spaces) {
                    return false;
                }
                str[i] = '0';
                --i;
                str[i] = '2';
                --i;
                str[i] = '%';

            } else {
                str[i] = str[pos];
            }
            pos--;
        }
        return true;
    }

    static void print(char[] str) {
        for (char c : str) {
            System.out.print(c);
        }
        System.out.println("");
    }
}
