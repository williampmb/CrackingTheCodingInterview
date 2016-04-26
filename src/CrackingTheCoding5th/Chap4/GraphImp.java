/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author William
 */
public class GraphImp {
    List<NodeGraph> vertices = new ArrayList<NodeGraph>();
    List<String> edges = new ArrayList<String>();
    
    public void resetVisit(){
        for(NodeGraph node : vertices){
            node.visited = false;
        }
    }
}
