/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author William
 * 
 * SAME CODE FOR Permutations Without/With Drops
 */
public class PermutationsWithoutDrops {

    public static void main(String[] args) {
        List<String> perm = perm("aabc");
        for (String p : perm) {
            System.out.println(p);
        }

    }

    public static List<String> perm(String input) {
        List<String> permutacoes = new ArrayList<String>();
        List<String> tmp = new ArrayList<String>();
        permutacoes.add("");
        for (int i = 0; i < input.length(); i++) {
            tmp = new ArrayList<String>();
            for (String p : permutacoes) {
                tmp.addAll(perm2(p, input.charAt(i) + ""));
            }
            permutacoes = tmp;
        }
        return permutacoes;
    }

    private static Set<String> perm2(String str, String pref) {
        Set<String> permutacoes2 = new HashSet<String>();
        if (str.equals("")) {
            permutacoes2.add(pref);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String com = str.substring(0, i);
                String fim = str.substring(i, str.length());
                String resultado = com + pref + fim;
                permutacoes2.add(resultado);
            }
            String resultado = str + pref;
            permutacoes2.add(resultado);
        }

        return permutacoes2;
    }
    
   
}
