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
public class FliptBitToWin {
    public static void main(String[] args){
        int b = ~5;
        System.out.println(Integer.toBinaryString(b));
        int a = flipBitToWin(b);
        System.out.println(a);
    }

    public static int flipBitToWin(int numb) {
        int last0 = -1, max = 0, count = 0;
        if (numb == 0) {
            return 1;
        }
        if (numb == 1) {
            return 2;
        }
        for (int i = 0; i < 32; i++) {
            if ((numb & (1 << i)) == 0) {
                if (last0 == -1) {
                    last0 = i;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = i - 1 - last0;
                    last0 = i;
                }
            }
            count++;
        }
        if(count>max) max = count;
        return max;
    }
}
