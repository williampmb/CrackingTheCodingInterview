/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th;

import CrackingTheCoding4th.recursion.Money;
import CrackingTheCoding4th.structures.Tree;

/**
 *
 * @author William
 */
public class CrackingTheCoding {

    /**
     * @param args the command line arguments
     */
 //   public static void main(String[] args) {
        
   
        
        /*   int[] a = new int[]{10,10,15,2,3,7};
        int[] b = new int[]{};
        int search = SortingAndSearching.search(a, 0, a.length-1, 10);
        
        System.out.println("result of serach: " + search);*/
     
        /*  int ways = Money.waysRepresentInCoin(30);
        System.out.println("ways: " + ways);*/
        /* int[] a = new int[8];
        a[0]=1;
        a[1]=5;
        a[2]=6;
        for(int j =3;j<a.length;j++){
        a[j] = Integer.MAX_VALUE;
        }
        int[] b = new int[]{0,2,3,7,8};
        SortingAndSearching.mergeBandA(b, a, 3);*/
//tower(4, 'S', 'A', 'D');
        /*  Graph g = new Graph();
        GraphVertices v1 = new GraphVertices(1);
        GraphVertices v2 = new GraphVertices(2);
        GraphVertices v3 = new GraphVertices(3);
        GraphVertices v4 = new GraphVertices(4);
        GraphEdge e1 = new GraphEdge(1, 2);
        GraphEdge e2 = new GraphEdge(1, 4);
        GraphEdge e3 = new GraphEdge(2, 3);
        GraphEdge e4 = new GraphEdge(4, 3);
        g.edges.add(e1);
        g.edges.add(e2);
        g.edges.add(e3);
        g.edges.add(e4);
        boolean rota = g.isRoute(1,2);
        System.out.println(rota);*/
        /*
        Tree root = new Tree();
        int array[] = {5,10,15,20,25,30,35};
        root.treeMinHeight(array, 0, array.length);
        int height = root.height();
        System.out.println("height: " + height);
        Tree.printTreeOrdered(root);
         */
   // }

        // simplest way to resolve a tower of hanoi
   public static void tower(int n, char sourceRod, char destRod, char auxRod){
       if(n==0){
           return;
       }
       
       tower(n-1, sourceRod, auxRod, destRod);
       
       System.out.println("Move the disk " + n + " from " + sourceRod + " to " + destRod);
       
       tower(n-1, auxRod, destRod, sourceRod);
   }
}
