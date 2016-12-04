/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicrosoftInterviewExample;

/**
 *
 * @author William
 */
public class WordsFromArrayAndDictionary {

    public static void main(String[] args) {
        String[] wordsToDic = {"go", "bat", "eat", "goal", "boy", "run","me"};
        char[] letters = {'e','o','l','b','a','m','g', '\n'};
        Dictionary dic = new Dictionary();
        
        dic.build(wordsToDic);
        
        dic.printAllWordsFromArray(letters);
    }
    
   
}
