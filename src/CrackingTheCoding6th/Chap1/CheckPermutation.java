package CrackingTheCoding6th.Chap1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William 1.2 - Given two strings, write a method to decide if one is a
 * permutation of the other.
 */
public class CheckPermutation {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/CrackingTheCoding6th/Chap1/input.txt"));
        
        String input = br.readLine();
        int count =0;
        while (input != null && !input.equals("")) {
            count++;
            String[] tk = input.split(" ");
            
            boolean result = permutation(tk[0], tk[1]);
            
            System.out.println(count + " - " +result);
            input = br.readLine();
        }
      
    }

    public static boolean permutation(String s1, String s2) {
        //store the values in a hashmap
        HashMap<Character, Integer> db = new HashMap<Character, Integer>();
        //permutation strings has same size
        if (s1.length() != s2.length()) {
            return false;
        }

        //increment the number of char in the hashmap
        for (char c : s1.toCharArray()) {
            if (db.get(c) == null) {
                db.put(c, 1);
            } else {
                int get = db.get(c);
                get++;
                db.put(c, get);
            }
        }

        //decrement the number of char in the hashmap
        for (char c : s2.toCharArray()) {
            if (db.get(c) == null) {
                return false;
            } else {
                int get = db.get(c);
                get--;
                if (get < 0) {
                    //in any case that it has an negative value of a letter
                    // it means it is not a permutation
                    return false;
                }
                db.put(c, get);
            }
        }
        //if nothing gets wrong, it is a permutation
        return true;
    }
}
