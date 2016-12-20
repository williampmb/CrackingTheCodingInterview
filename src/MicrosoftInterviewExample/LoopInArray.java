/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicrosoftInterviewExample;

import java.util.BitSet;

/**
 *
 * @author William
 * 
 * You are given an array of positive and negative integers. 
 * If a number n at an index is positive, then move forward n steps. 
 * Conversely, if it's negative, move backward n steps. 
 * Determine if there is a loop in this array. 
 * obs:  A loop is something that starts and ends at a particular index. 
 * 
 */
public class LoopInArray {
    public static void main(String[] args){
        int[] array = {3,2,2,-1};
        boolean hasLoop = hasLoop(0,array);
        System.out.println(hasLoop);
    }
    public static boolean hasLoop(int start, int[] array){
        BitSet db = new BitSet(array.length);
        int pos=start;
        for(int i =0;i<array.length+1;i++){
            if(db.get(pos)) return false;
            db.set(pos);
            pos = pos + array[pos];
            if(pos < 0) pos = (pos%array.length) + array.length-1;
            else  pos = (pos%array.length);
            if (pos == start)  return true;
        }
        return false;
    }
}
