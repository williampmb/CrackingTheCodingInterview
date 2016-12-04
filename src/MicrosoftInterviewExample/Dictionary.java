/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicrosoftInterviewExample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
//TODO - let this intData generic
public class Dictionary {

    boolean word;
    Dictionary[] child;
    
    public Dictionary(){
        child = new Dictionary[26];
        word = false;
    }

    private int validChar(int asc) {
        if (asc > 96 && asc < 123) {
            return asc;
        } else if (asc > 64 && asc < 91) {
            return asc + 32;
        } else {
            return -1;
        }
    }

    public void build(String[] words) {

        for (String w : words) {
            add(w);
        }
    }

    private void add(String w) {
        Dictionary current = this;
        for (char c : w.toCharArray()) {
            if(validChar(c)== -1){
                continue;
            }
            if (current.child[c - 97] == null) {
                current.child[c - 97] = new Dictionary();
                current = current.child[c - 97];
            } else {
                current = current.child[c - 97];
            }
        }
        current.word = true;
    }

    public void printAllWordsFromArray(char[] letters) {
        StringBuilder let = new StringBuilder();
        for(char c: letters){
            if(validChar(c)!= -1){
                let.append(c);
            }
        }
        letters = let.toString().toCharArray();
        for(char c: letters){
            if(child[c-97] != null){
                child[c-97].findWords(letters, ""+c);
            }
        }
    }

    private void findWords(char[] letters, String string) {
        if(word){
            System.out.println(string);
        }
        for(char c:letters){
            if(child[c-97]!= null){
                child[c-97].findWords(letters, string+c);
            }
        }
    }

}
