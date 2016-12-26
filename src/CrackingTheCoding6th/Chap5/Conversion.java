/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap5;

/**
 *
 * @author William
 */
public class Conversion {
    public static void main(String[] args){
        int c = conversion(3, 3);
        System.out.println(c);
    }

    public static int conversion(int a, int b){
        int result = a ^b;
        int count=0;
        if(result == 0) return 0;
        for(int i=0; i <32;i++){
            if((result &(1<<i)) !=0){
                count++;
            }
        }
        return count;
    }
}
