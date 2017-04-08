/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap2;

import datastructures.MyLinkedList;
import static datastructures.MyLinkedList.createMyLinkedList;

/**
 *
 * @author William
 */
public class Partition {

    public static void main(String[] args) {

        int[] array = {3, 5, 8, 5, 10, 2, 1};
        
        MyLinkedList head = createMyLinkedList(array);
        int x = 5;
        
        partition(head, x);
    }

    

    //Time Complexity = O(n)
    //Space Complexity = O(n)
    private static void partition(MyLinkedList head, int x) {
        MyLinkedList left = null;
        MyLinkedList leftEnd = null;
        MyLinkedList right = null;
        MyLinkedList cur = head;
        MyLinkedList tmp = null;

        while (cur != null) {
            tmp = cur.getNext();
            if (cur.getData() < x) {
                if (left == null) {
                    left = cur;
                    left.setNext(left);
                    leftEnd = left;
                    cur = tmp;
                } else {
                    cur.setNext(left);
                    left = cur;
                    cur = tmp;
                }
            } else if (right == null) {
                right = cur;
                right.setNext(null);
                cur = tmp;
            } else {
                cur.setNext(right);
                right = cur;
                cur = tmp;
            }

        }
        leftEnd.setNext(right);
        left.print();
    }
}
