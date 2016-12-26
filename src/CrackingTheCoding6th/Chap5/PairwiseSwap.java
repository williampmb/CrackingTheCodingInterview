/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap5;

/**
 *
 * @author William
 * 
 *  Write a program to swap odd and even bits in an integer with as few 
 * instructions as possible (e.g., bit 13 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on)
 */
public class PairwiseSwap {

    public static void main(String[] args){
        pairwiseSwap2(7);
        
    }
    
    
    public static int pairwiseSwap(int numb) {
        int result = 0;
        for (int i = 0; i < 32; i = i+2) {
            int mask = ((~((~0) << 2)) << i);
            result |= ((((numb&mask)>>>1&mask))|(((numb&mask)<<1))&mask);
        }
        System.out.println("previous: " + Integer.toBinaryString(numb));
        System.out.println("after: " + Integer.toBinaryString(result));
        return result;
    }
    
    public static int pairwiseSwap2(int numb) {
        int result = 0;
        int oddMask = 0xAA;
        int evenMask = 0x55;
        result |= ((oddMask&numb)>>>1) | ((evenMask&numb)<<1);
        System.out.println("previous: " + Integer.toBinaryString(numb));
        System.out.println("after: " + Integer.toBinaryString(result));
        return result;
    }
}
