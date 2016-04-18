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
public class SortingAndSearching {

    // Given two sorted arrays which a has enough space for a +b elements, merge them to keep sorted
    //solved but not optimized
    public static int[] mergeBandA(int[] b, int[] a, int numElemOfA) {
        int posb = 0;
        int posa = 0;
        int count;
        int aux;
        boolean insert;
        while (posb < b.length) {
            insert = false;
            if (posa == (numElemOfA + posb)) {
                for (int i = posb; i < b.length; i++) {
                    a[posa] = b[i];
                    posb++;
                }
            } else {
                count = 0;
                aux = posb;

                while (b[aux] < a[posa]) {
                    count++;
                    aux++;
                    insert = true;
                }

                if (insert) {
                    for (int i = numElemOfA + posb - 1; i >= posa; i--) {
                        a[i + count] = a[i];

                    }
                    for (int i = posa; i < count + posa; i++) {
                        a[i] = b[posb];
                        posb++;
                    }
                    for (int i = 0; i < count; i++) {
                        posa++;
                    }
                } else {
                    posa++;
                }

            }
        }
        return null;
    }

    //Given a sorted array of n integers that has been rotated an unkown number of times, give an O(log n)
    //algorithm that fins an element in the array. You may assume that the array was originally sorted in increasing order.
    public static int search(int[] a, int posIni, int posFin, int value) {
        int mid = (posFin + posIni) / 2;
        if (a.length == 0) {
            return -1;
        }
        if (value == a[mid]) {
            return mid;
        }else{
            if(posIni>posFin)return -2;
            if(value > a[mid]){
                if(value <= a[posFin]){
                    posIni = mid + 1;
                }else{
                    posFin = mid - 1;
                }
            }else{
                posFin = mid - 1;

            }
        }
        mid = search(a,posIni,posFin,value);
        return mid;
    }
    
    //Given a sorted array of string which is interspersed with empty strings, write a method to find the location of a given string
   /* public static int searchString(String[] s, int posIni, int posFin, String value){
        if(s.length ==0) return -1;
        int mid = (posIni + posFin)/2;
        if(s[mid].equals(value)) return mid;
        if(s[mid].charAt(0)>= )
        
        //return 0;
    }*/
    
    
}
