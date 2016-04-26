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
    
    //#2.2
    public static Node findKthToLast(Node head, int k){
        Node current = head;
        Node ref = head.next;
        int steps =1;
        if(k<0) return null;
        if(current == null) return null;
        
        while(steps < k){
            if(ref.next == null && steps != k ){
                System.out.println("Incompatible K and number of nodes");
                return null;
            }
            ref = ref.next;
            steps++;
        }
        
        while(ref.next != null){
            ref = ref.next;
            current = current.next;
        }
        
        return current;
    }
}
