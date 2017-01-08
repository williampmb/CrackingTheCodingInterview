/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap8;

import datastructures.MyStack;

/**
 *
 * @author William
 */
public class TowersOfHanoi {
    static MyStack origin = new MyStack(4);
    static MyStack destination = new MyStack(4);
    static MyStack buffer = new MyStack(4);
    
    public static void main(String[] args){
        origin.push(4);
        origin.push(3);
        origin.push(2);
        origin.push(1);
        
        moveDisks(4, origin, destination, buffer);
    }
    
    public static void moveDisks(int n, MyStack ori, MyStack dest, MyStack buf){
        if(n<=0) return;
        moveDisks(n-1, ori, buf, dest);
        moveTop(ori,dest);
        moveDisks(n-1,buf,dest,ori);
    }

    private static void moveTop(MyStack ori, MyStack dest) {
       dest.push(ori.pop());
    }
    
}
