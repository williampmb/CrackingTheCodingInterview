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
public class LinkedListQt {
    //#2.1 Write code to remove duplicate from an unsorted linked list. No buffer allowed   
    public static void removeDuplicatedNode(Node head){
        Node p1 = head;
        while(p1 != null){
            Node pai = p1;
            Node p2 = pai.next;
            while(p2 != null){
                if(p2.data == p1.data){
                    p2 = p2.next;
                    pai.next = p2;
                }else{
                    pai = pai.next;
                    p2= p2.next;
                }
            }            
            p1 = p1.next;
        }
    }
}
