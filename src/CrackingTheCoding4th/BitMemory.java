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
public class BitMemory {
    int[] bitset;
    
    public BitMemory(int size){
        bitset = new int[size>>5]; //divide by 32
    }
    
    boolean get (int pos){
        int wordNumber = (pos>>5); //divide by 32
        int bitNumber = (pos &0x1F); //mod 32
        return (bitset[wordNumber] & (1<<bitNumber)) !=0;
    }
    
    void set(int pos){
        int wordNumber = (pos>>5); //divide by 32
        int bitNumber = (pos&0x1F); //mod 32
        bitset[wordNumber] |= 1<<bitNumber;
    }
    
    public static void checkDubplicates(int[] array){
        BitMemory bm = new BitMemory(32000);
        for(int i = 0;i<array.length;i++){
            int num = array[i];
            int num0 = num-1; //bitmemory starts at 0, numbers start at 1
            if(bm.get(num0)){
                System.out.println("num: " + num);
            }else{
                bm.set(num0);
            }
        }
    }
}
