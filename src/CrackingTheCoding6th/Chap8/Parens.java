/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author William
 */
public class Parens {

    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        /*Set<String> parens = parens(3);
        for(String s : parens){
            System.out.println(s);
        }*/

        parens3(2);
    }

    public static Set<String> parens(int n) {
        Set<String> comb = new HashSet<String>();
        if (n <= 0) {
            comb.add("");
            return comb;
        }

        for (String s : parens(n - 1)) {
            comb.add("()" + s);
            comb.add(s + "()");
            comb.add("(" + s + ")");

        }
        return comb;
    }

    public static void parens2(int n) {
        parens2("", n);
    }

    private static void parens2(String seq, int max) {
        if (seq.length() == max * 2) {
            Integer get = map.get(seq);
            if ( get  == null) {
                map.put(seq, 1);
                System.out.println(seq);
            }
           
        } else {
            parens2("()"+seq, max);
            parens2(seq+"()", max);
            parens2("("+seq+")", max);
        }
    }
    
    
    static void parens3(int n){
        List<String> seqs = new ArrayList<String>();
        char[] seq = new char[n*2];
        createValidSeq(n,n,seqs,seq, 0);
        for(String s: seqs){
            System.out.println(s);
        }
        
    }


    private static void createValidSeq(int left, int right, List<String> seqs, char[] seq, int index) {
      if(left>right ||left<0) return;
      if(left ==0 && right == 0){
          seqs.add(String.copyValueOf(seq));
      }else{
          seq[index] = '(';
          createValidSeq(left-1, right, seqs, seq, index+1);
          
          seq[index] = ')';
          createValidSeq(left, right-1, seqs, seq, index+1);
      }
    }

}
