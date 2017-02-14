/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap17;

/**
 *
 * @author William
 */
public class AddWithoutPlus {

    public static void main(String[] args) {

        int s = somaSemOperadores(1011, 1354);
        System.out.println(s);
    }

    public static int somaSemOperadores(int a, int b) {

        int add = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            //if ultimo e tem 1 no add ?
            int bitA = (a & (1 << i));
            int bitB = (b & (1 << i));

            if ((bitA & bitB) >= 1) {

                if (add == 1) {
                    sum |= 1 << i;
                }
                add = 1;
            } else {
                int bitSum = (bitA | bitB);
                if (add == 1) {
                    if ((bitSum & (add << i)) >= 1) {
                        sum |= (sum & ~(1 << i));
                        add = 1;
                    } else {
                        sum |= 1 << i;
                        add = 0;
                    }

                } else {
                    sum |= bitSum;
                }
            }

        }
        return sum;
    }
}
