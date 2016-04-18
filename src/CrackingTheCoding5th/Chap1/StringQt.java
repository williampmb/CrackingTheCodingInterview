/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap1;

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
}
