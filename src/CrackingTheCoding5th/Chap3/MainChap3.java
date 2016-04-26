/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap3;

/**
 *
 * @author William
 */
public class MainChap3 {
   
    public static void main(String[] args){
         //ThreeStacksOnOneArray s = new ThreeStacksOnOneArray(3, 6);
        //s.pop(1);
        System.out.println("test");
        
        StackOfStacks b = new StackOfStacks(2, 2);
        b.push(2);
        b.push(3);
        b.push(5);
        b.push(5);
        
        int a = b.pop();
                System.out.println(a);
        a = b.pop();
                System.out.println(a);
        a = b.pop();
                System.out.println(a);
        a = b.pop();
                System.out.println(a);
        a = b.pop();
        
        b.push(7);
        System.out.println(a);
        a = b.pop();
                System.out.println(a);
    }
}
