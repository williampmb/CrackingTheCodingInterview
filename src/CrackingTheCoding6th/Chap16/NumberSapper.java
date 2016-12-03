/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

/**
 *
 * @author William Write a function to swap a number in place (that is, without
 * temporary variables).
 */
public class NumberSapper {

    public static void main(String[] args) {
        int[] a = {3};
        int[] b = {4};

        swap(a, b);
        String toBinaryString = Integer.toBinaryString(a[0]);
        String toBinaryString1 = Integer.toBinaryString(b[0]);

        System.out.println("a: " + a[0] + " b: " + b[0]);
        
        
    }

    public static void swap(int[] a, int[] b) {
       /* for (int i = 0; i < 32; i++) {
            System.out.println("i: " + i + " " + Integer.toBinaryString(a[0] & (1 << i)) + " " + Integer.toBinaryString(b[0] & (1 << i)));
            if (((a[0] & (1 << i)) ^ (b[0] & (1 << i))) != 0) {
                if ((a[0] & (1 << i)) == 0) {
                    a[0] |= (1 << i);
                    b[0] &= ~(1 << i);
                } else {
                    b[0] |= (1 << i);
                    a[0] &= ~(1 << i);
                }
            }
        }
        
        */
       
       a[0]= a[0]^b[0];
       b[0]= a[0]^b[0];
       a[0]= a[0]^b[0];
        //System.out.println("a2: " +Integer.toBinaryString(a) + " b2: " + Integer.toBinaryString(b));
    }
}
