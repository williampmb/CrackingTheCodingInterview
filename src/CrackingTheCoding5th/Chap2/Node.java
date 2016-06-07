/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap2;

/**
 *
 * @author William
 */
public class Node {

    Node next = null;
    int data;

    Node(int d) {
        data = d;
    }

    void appendToEnd(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void print() {
       
        Node n = this;
        while (n != null) {
            System.out.print(n.data);
            System.out.print(" - ");
            n = n.next;
        }
        System.out.println("");
    }

    void print(int forward) {
        int count = 1;
        System.out.print(data);
        Node n = this;

        while (n.next != null) {
            System.out.print(" - ");
            n = n.next;
            System.out.print(n.data);
            if (++count == forward) {
                break;
            }
        }
        System.out.println("");
    }
}
