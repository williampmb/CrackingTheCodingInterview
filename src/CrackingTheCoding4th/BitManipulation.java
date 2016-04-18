/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th;

/**
 *
 * @author William
 */
public class BitManipulation {
    //M is a substring of N
    public static int MSubstingN(int n, int m, int i, int j){
        int fullInt = Integer.MAX_VALUE;
        int cleanM, cleanN;
        int cleanNleft, cleanNRight;
        System.out.println("r");
        if(i>j || i<0 || j>32) return 0;
        System.out.println("n: " + Integer.toBinaryString(n) + " - " + n);
        System.out.println("m: " + Integer.toBinaryString(m) + " - " + m);
        
        //Fix m side
        
        System.out.println("fullInt: " + Integer.toBinaryString(fullInt));
        cleanM = fullInt << j-i;
        System.out.println("cleanM: " + Integer.toBinaryString(cleanM) + " fullInt pushed "+ (j-i) + " bits to the left.");
        cleanM = ~cleanM;
        System.out.println("cleanM: " + Integer.toBinaryString(cleanM) + " negative of last cleanM");
       
        m = cleanM & m;
        System.out.println("m: " + Integer.toBinaryString(m) + " m& cleanM to clear the part that we don't want");
        
         m = m << i;
        System.out.println("m: " + Integer.toBinaryString(m) + " m pushed "+i+" bits to the left");
        //reset values
        
        
        // fix n side
        cleanNRight = Integer.MAX_VALUE;
        cleanNRight = cleanNRight << (j);
        System.out.println("cleanNRight: " + Integer.toBinaryString(cleanNRight));
        cleanNleft = Integer.MAX_VALUE;
        cleanNleft = cleanNleft >> 32 - i-1;
        System.out.println("cleanNleft: " + Integer.toBinaryString(cleanNleft));
        cleanN = cleanNleft | cleanNRight;
        System.out.println("cleanN: " + Integer.toBinaryString(cleanN));
        n = n & cleanN;
        System.out.println("n: " + Integer.toBinaryString(n));
        
        // mix n 'n' m
        
        n = n|m;
        System.out.println("final n: " + Integer.toBinaryString(n) + " " + n);
        return n;
    }
}
