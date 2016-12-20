/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap5;

import java.util.LinkedList;

/**
 *
 * @author William
 */
public class NextNumber {
    
    public static void main(String[] args){
                System.out.println(Integer.toBinaryString(-2));

        nextNumber(7);
    }
    public static void nextNumber(int numb){
        if(numb == 0 ||(numb^~0)==0){
            System.out.println("Erro");
            return;
        }
        printNextBig(numb);
        printNextSmall(numb);
    }

    private static void printNextBig(int numb) {
        int first1 =0, next0;
        while((numb&(1<<first1))== 0){
            first1++;
        }
        next0=first1;
        while((numb&(1<<next0))!=0){
            next0++;
            if(next0 == 32){
                System.out.println("Erro");
                return;
            }
        }
        int big = setBit(numb,next0);
        big = clearBit(big,next0-1);
        System.out.println(Integer.toBinaryString(big));
    }

    private static void printNextSmall(int numb) {
        int first0=0,next1;
        while((numb&(1<<first0))!=0){
            first0++;
        }
        next1=first0;
        while((numb&(1<<next1))==0){
            next1++;
            if(next1==32){
                System.out.println("Erro");
                return;
            }
        }
        int small = setBit(numb, next1-1);
        small = clearBit(small, next1);
        System.out.println(Integer.toBinaryString(small));
    }

    private static int setBit(int numb, int i) {
        return numb | (1<<i);
    }

    private static int clearBit(int numb, int i) {
        return numb&~(1<<i);
    }
    
    public void printIntegerToBinary(int numb){
        LinkedList<Integer> store = new LinkedList<Integer>();
        StringBuilder bi = new StringBuilder();
        while(numb/2!=1){
            store.add(numb%2);
            numb /=2;
        }
        store.add(1);
        while(store != null){
            bi.append(store.remove());
        }
        System.out.println(bi.toString());
    }
}
