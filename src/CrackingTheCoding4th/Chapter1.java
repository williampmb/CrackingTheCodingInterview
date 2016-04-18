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
public class Chapter1 {
     public static boolean anagram(String str1, String str2) {
        if (str1 == null || str1 == null) {
            return false;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        if (s1.length != s2.length) {
            return false;
        }
        for (int i = 0; i < s1.length; i++) {
            int j;
            for (j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    s2[j] = 0;
                    break;
                }
                if (j == s2.length - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    //implementado incorretamente 1.3
    public static void removeDuplicateCharacter(char[] str) {
        if (str == null) {
            return;
        }
        int len = str.length;
        if (len < 2) {
            return;
        }

        int tail = 1;

        for (int i = 1; i < len; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == tail) {
                str[tail] = str[j];
                ++tail;
            }
        }
        str[tail] = 0;
    }

    //1.1
    public static boolean isUniqueCharacter(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    //If an Element is 0 in a Matrix, The entire row and column are set as 0
    public static void zeroRowNColumn(int[][] matriz) {

        boolean[] colVector = new boolean[matriz[0].length];
        boolean[] rowVector = new boolean[matriz.length];
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                if (matriz[row][col] == 0) {
                    rowVector[row] = true;
                    colVector[col] = true;

                } /*else {
                    rowVector[row] = false;
                    colVector[col] = false;

                }*/
            }
        }

        for (int row = 0; row < matriz.length; row++) {
            if (rowVector[row]) {
                for (int col = 0; col < matriz[0].length; col++) {
                    matriz[row][col] = 0;
                }
            }
        }
        for (int col = 0; col < matriz[0].length; col++) {
            if (colVector[col]) {
                for (int row = 0; row < matriz.length; row++) {
                    matriz[row][col] = 0;
                }
            }
        }
        printMatrix(matriz);
    }

    public static void printMatrix(int[][] m) {
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                System.out.print( m[row][col]+ " ");
            }
            System.out.println("");
        }
    }
}
