/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th.recursion;

/**
 *
 * @author William
 */
public class Money {

    public static int waysRepresentInCoin(int cents) {
        int way = 0;
        if (cents < 0) {
            System.out.println("Erro: value less than 0");
        } else {
            if(cents == 0){
                return 0;
            }else if (cents < 5) {
                return 0;
            }else if (cents >= 25) {
                way = way + waysRepresentInCoin(cents - 25) + 13;
            }else if (cents >= 10) {
                way = way + waysRepresentInCoin(cents - 10) + 4;
            }else if (cents >= 5) {
                way = way + waysRepresentInCoin(cents - 5) + 2;
            } 
        }
        return way;
    }
}
