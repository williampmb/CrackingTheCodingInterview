/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author William
 */
public class Graph {
    ArrayList<GraphEdge> edges;
    HashSet<GraphVertices> vertices;

    public Graph() {
        edges = new ArrayList<GraphEdge>();
        vertices = new HashSet<GraphVertices>();
    }
    
    

    public ArrayList<GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<GraphEdge> edges) {
        this.edges = edges;
    }

    public HashSet<GraphVertices> getVertices() {
        return vertices;
    }

    public void setVertices(HashSet<GraphVertices> vertices) {
        this.vertices = vertices;
    }
  
    
    
    public boolean isRoute(int node1, int node2){
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<GraphEdge> aux = getEdges();
        
        s.push(node1);
        while(s.size() != 0){
            int walk = s.pop();
            
            for(int i =0; i< aux.size(); i++){
               GraphEdge e = aux.get(i);
               if(walk == e.node1){
                    if(e.node2 == node2) return true;
                    s.push(e.node2);
                    aux.remove(e);
                }else if( e.node2 == walk ){
                    if(e.node1 == node2) return true;
                        s.push(e.node1);
                        aux.remove(e);
                } 
            }
          //  for(GraphEdge e : aux){
                
                
           // }
        }
        
        return false;
    }
}
