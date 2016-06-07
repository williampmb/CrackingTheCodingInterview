/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap2;

import java.util.HashMap;

/**
 *
 * @author William
 */
public class LinkedListQt {

    //#2.1 Write code to remove duplicate from an unsorted linked list. No buffer allowed   
    public static void removeDuplicatedNode(Node head) {
        Node p1 = head;
        while (p1 != null) {
            Node pai = p1;
            Node p2 = pai.next;
            while (p2 != null) {
                if (p2.data == p1.data) {
                    p2 = p2.next;
                    pai.next = p2;
                } else {
                    pai = pai.next;
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }
    //END #2.1
    

    //#2.2 Find the kth to the last element of a singly linked list
    public static Node findKthToLast(Node head, int k) {
        Node current = head;
        Node ref = head.next;
        int steps = 1;
        if (k < 0 || current == null) {
            return null;
        }

        while (steps < k) {
            if (ref.next == null && steps != k) {
                System.out.println("Incompatible K and number of nodes");
                return null;
            }
            ref = ref.next;
            steps++;
        }

        while (ref.next != null) {
            ref = ref.next;
            current = current.next;
        }

        return current;
    }
    
    //END #2.2

    //#2.3 Delete a node in the middle of a singly linkedlist
    // given only access to that node
    public static void deleteTheValue(Node c) {
        Node current = c;
        while (current != null) {
            if (current.next == null) {
                current = null;
                break;
            }
            current.data = (current.next).data;
            current = current.next;
        }
    }
    //END #2.3

    //#2.5 you have two numbers represented by a linked list, where each node contains
    // a single digit. the digits are stored in reverse order, such that the 1's digit
    //is at the head of the list. Write a function that adds the two numbers and returns 
    //the sum as a linked list.
    public static Node sumLinkedList(Node lnum1, Node lnum2) {
        int num1 = transformLlToNum(lnum1);
        int num2 = transformLlToNum(lnum2);
        int num3 = num1 + num2;

        return transformNumToLl(num3);
    }

    private static int transformLlToNum(Node lnum1) {
        int num = 0;
        int exp = 0;
        while (lnum1 != null) {
            num += lnum1.data * Math.pow(10, exp);
            exp++;
            lnum1 = lnum1.next;
        }
        return num;
    }

    private static Node transformNumToLl(int num3) {
        Node head = new Node(0);
        Node current = head;
        int exp = 0;
        int res = num3;
        while (((int) (num3 / Math.pow(10, exp))) != 0) {
            exp++;
        }
        exp--;
        while (exp > -1) {
            int alg = (int) (res / Math.pow(10, exp));
            current.data = alg;

            res = (int) (res % Math.pow(10, exp));
            exp--;
            if (exp > -1) {
                current.next = new Node(0);
                current = current.next;
            }

        }
        return head;
    }
    //END #2.5

    //#2.6 Given a circular linked list, implement an algorithm which retrns the 
    //node at the beginning of the loop
    public static Node returnLoop(Node head){
      
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        Node current = head;
        while(current != null){
            if(map.get(current.toString()) == null){
                map.put(current.toString(), 1);
            }else{
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    //END #2.6
    
    //#2.7 Implement a function to check if a linked list is a palindrone
    public static boolean isPlaindrone(Node head){
        Node forward = head;
        Node reverse = getReverse(head);
        forward.print();
        reverse.print();
        while(forward != null){
            if(reverse == null) return false;
            if(forward.data != reverse.data){
               return false; 
            }
            forward = forward.next;
            reverse = reverse.next;
            
        }
        
        return true;
    }

    private static Node getReverse(Node head) {
        Node current = head;
        Node reverse = null;
        
        while(current != null){
            Node newValue = new Node(0);
            newValue.data = current.data;
            newValue.next = reverse;
            reverse = newValue;
            current = current.next;
        }
        return reverse;
    }
    //END #2.7
}
