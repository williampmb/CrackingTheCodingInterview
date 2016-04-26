/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author William
 */
public class NodeGraph {
    List<NodeGraph> adjacents = new ArrayList<>();
    boolean visited = false;
    String data;

    public NodeGraph() {
    
    }
    public NodeGraph(List nodes, String value) {
        adjacents = nodes;
        data= value;
    }
    
    
    
    public static String dfs(NodeGraph any){
        String result = any.data;
        any.visited = true;
        
        for(NodeGraph around : any.adjacents){
            if(!around.visited){
                result += dfs(around);
            }
        }
        return result;
    }
    
    public static String bfs(NodeGraph any){
        Queue q = new LinkedList();
        q.add(any);
        any.visited = true;
        String result = any.data;
        
        while(!q.isEmpty()){
            any = (NodeGraph) q.poll();
            for(NodeGraph n : any.adjacents){
                if(!n.visited){
                    result+=n.data;
                    n.visited = true;
                    q.add(n);
                }
            }
        }
        
        return result;
    }
    
    public boolean searchRoute(NodeGraph any, NodeGraph looking){
        boolean result = false;
        any.visited = true;
        
        if(any.data.equals(looking.data)) return true;
        
        for(NodeGraph around : any.adjacents){
            if(!around.visited){
                result = searchRoute(around, looking);
            }
        }
        return result;
    }
    
}
