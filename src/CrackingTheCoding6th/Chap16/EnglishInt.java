/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

import java.util.LinkedList;

/**
 *
 * @author William
 */
public class EnglishInt {

    public static void main(String[] args) {
        printNumbName(-26384123);
    }

    public static void printNumbName(int num) {
        if (num == 0) {
            System.out.println("Zero");
            return;
        }

        String[][] dic = {{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
        {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"},
        {"hundred"},
        {"", "thousand", "million"}};
        
        int each3, each2, count = 0;
        boolean positive = true;
        LinkedList<String> name = new LinkedList<String>();
        if (num < 0) {
            positive = false;
        }
        num = Math.abs(num);
        while (num > 0) {
            each3 = num % 1000;
            if (each3 != 0) {
                name.add(dic[3][count]);
            }
            each2 = each3 % 100;
            if (each2 != 0) {
                if (each2 < 20) {
                    name.add(dic[0][each2]);
                } else {
                    int tens = each2 / 10;
                    int ones = each2 % 10;

                    name.add(dic[0][ones]);
                    name.add(dic[1][tens]);
                }
            }
            each3 = each3 / 100;
            if (each3 != 0) {
                if (each2 != 0) {
                    name.add("and");
                }
                
                name.add(dic[2][0]);
                name.add(dic[0][each3]);
            }
            count++;
            num = num / 1000;
        }

        if (!positive) {
            System.out.print("negative ");
        }

        while (name.peek() != null) {
            String poll = name.removeLast();
            System.out.print(poll + " ");
        }
        System.out.println("");

    }
}
