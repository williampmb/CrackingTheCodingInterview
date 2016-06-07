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
public class MainChap2 {

    public static void main(String[] args) {
        test27();
    }

    //Code to test question #2.2
    public static void test22() {
        Node revDup = new Node(4);
        revDup.appendToEnd(1);
        revDup.appendToEnd(3);
        revDup.appendToEnd(6);
        revDup.appendToEnd(4);
        revDup.appendToEnd(2);
        revDup.print();
        Node r = LinkedListQt.findKthToLast(revDup, 3);
        System.out.println(r.data);
    }

    //Code to test question ##2.3
    public static void test23() {
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println("------TEST1----------");
        System.out.println("Print the whole linked list.");
        a.print();
        System.out.println("Remove item " + c.data);
        LinkedListQt.deleteTheValue(c);
        System.out.println("Remove and print the rest of the list");
        a.print();
        System.out.println("----------------");

    }

    public static void test25() {
        Node a = new Node(7);
        Node b = new Node(1);
        Node c = new Node(6);
        Node d = new Node(5);
        Node e = new Node(9);
        Node f = new Node(2);

        a.next = b;
        b.next = c;
        c.next = null;
        System.out.println("print the first list");
        a.print();
        
        d.next = e;
        e.next = f;
        f.next = null;

        System.out.println("print the second list");
        d.print();
        Node h = LinkedListQt.sumLinkedList(a, d);

        System.out.println("the result");
        h.print();
    }
    
    public static void test26(){
        Node a = new Node(7);
        Node b = new Node(1);
        Node c = new Node(99);
        Node d = new Node(5);
        Node e = new Node(9);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;
        
        Node repeated = LinkedListQt.returnLoop(a);
        System.out.println("value: " + repeated.data);
    }
    
    public static void test27(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        
        a.print();
        boolean is = LinkedListQt.isPlaindrone(a);
        
        System.out.println(is);
        
    }
    

}
