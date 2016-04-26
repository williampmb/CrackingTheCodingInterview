/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicrosoftInterviewExample;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author William
 */
public class Main {
    static HashMap<String,String> map = new HashMap<String,String>();
    
    public static void main(String[] args){
        map.put("1", "abc");
        map.put("2", "def");
        
        printPossibilities("2112");
    
    }
    
    public static void printPossibilities(String input){
        ArrayList<String> base = new ArrayList();
        String charAt = "" +  input.charAt(0);
        String get = map.get(charAt);
        char[] toCharArray = get.toCharArray();
        for(char c : toCharArray){
            String d = "" + c;
            base.add(d);
            
        }
        
        for(int i =1; i< input.length(); i++){
            String da = "" + input.charAt(i);
            char[] array2 = map.get(da).toCharArray();
            base = merge(base, array2);
            
        }
        
        for(String h : base){
           
            System.out.println(h);
        }
    }

    private static ArrayList merge(ArrayList<String> base, char[] array2) {
        ArrayList res = new ArrayList();
        for(char t : array2){
           
            for(String x : base){
                String y = "" + t + x;
                res.add(y);
            }
        }
        
        return res;
    }
    
    
}
