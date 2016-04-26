/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author William
 */
public class Main {
    public static void main(String[] args){
        NodeGraph a = new NodeGraph();
        NodeGraph b = new NodeGraph();
        NodeGraph c = new NodeGraph();
        NodeGraph d = new NodeGraph();
        
        a.data ="a";
        b.data ="b";
        c.data = "c";
        d.data = "d";
        
        List l1 = new ArrayList();
        l1.add(b);
        l1.add(d);
        List l2 = new ArrayList();
        l2.add(c);
        List l3 = new ArrayList();
        l2.add(a);
        
        a.adjacents = l1;
        b.adjacents = l2;
        c.adjacents = l3;
        
        System.out.println(NodeGraph.bfs(a));
        
        
        Map t3 = new HashMap();
        
    }
}
