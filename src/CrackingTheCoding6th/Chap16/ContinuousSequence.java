/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

/**
 *
 * @author William
 */
public class ContinuousSequence {

    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        int[] b = {100, -100, -200, 300, -100, 10};

        continuosSeq(b);
    }

    private static void continuosSeq(int[] a) {
        int ini = 0, fin = 0, sum = a[0], maiorSoma = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            if (sum > maiorSoma) {
                maiorSoma = sum;
                fin = i;
            } else if (maiorSoma < a[i]) {
                maiorSoma = a[i];
                ini = i;
                fin = i;
                sum = a[i];
            }
        }

        for (int i = ini; i <= fin; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
