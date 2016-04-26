/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author William
 */
public class StringQt{
    
    //#1.1 Write code to verify if a string has all unique characters. No extra data structures
    public static boolean hasUniqueChar(String str){
        int db = 0; //a int can hold 32bits, so it has 32 references to an char. The alphabet has 26.
        
        str = str.toLowerCase(); // A is different than a. So lowercase to fit on the 32 array bit as int.
        
        for(int i =0; i< str.length(); i++){
            int charAsInt = str.charAt(i) -97; // convert the char into the ascii number and subtract the number of the first one a - 97
            if(charAsInt<0){
                System.out.println(str.charAt(i) + " - char is not in the alphabet");
                continue;
            }
            int marker = 1<<charAsInt; //take the position to place in array bit
            if((db&marker)>0){
                return false; //the letter already exists on the db
            }else{
                db = db | marker; //set 1 in database at the position that correspond the letter
            }
        }
        return true;
    }
    
    //#1.3
    public static boolean permutation(String str1, String str2){
        Map<Integer,Integer> str1Map = new HashMap();
        Map<Integer,Integer> str2Map = new HashMap();
        
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("") || str1.length() != str2.length()) return false;
        
        
        
        for(int i =0; i< str1.length();i++){
            int str1Char = str1.charAt(i);
            int str2Char = str2.charAt(i);
        
            int count1 = str1Map.get(str1Char) == null ? 0 : str1Map.get(str1Char) ;
            int count2 = str2Map.get(str2Char) == null ? 0 : str2Map.get(str2Char) ;
         
            count1++;
            count2++;
            str1Map.put(str1Char, count1);
            str2Map.put(str2Char, count2);
        }
        
        for(Integer a : str1Map.keySet()){
            int totalChar1 =  str1Map.get(a);
            int totalChar2 =  str2Map.get(a);
            if(totalChar1 != totalChar2){
                return false;
            }
        }
        
        return true;
    }
}
