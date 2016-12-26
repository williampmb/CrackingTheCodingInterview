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
public class Debugger {
    //verify if numb is power of two
    public static boolean isPowerOfTwo(int numb){
        return ((numb&(numb-1))==0);
    }
}
