/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

/**
 *
 * @author William
 * 
 *  Design a method to find the frequency of occurrences of any given word in a book. What if we were running this algorithm multiple times? 
 *  assuming that a book doesn't have punctuation.
 */
public class WordFrequencies {
    public static void main(String[] args){
        String book = "Once upon a time a little kid went to the florest and"
                + " the kid has so much fun with the animals However there is "
                + "a bad wolf that wanted to eat he kid";
        Dictionary dic = Dictionary.build(book);
        int r = dic.frequencyOnBookOf("once");
        System.out.println(r);
    }
}
