/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap16;

/**
 *
 * @author William
 */
public class Dictionary {

    int data;
    Dictionary[] child;
    int numLetter = 26;

    public Dictionary() {
        this.child = new Dictionary[numLetter];
    }

    public static Dictionary build(String book) {
        Dictionary dic = new Dictionary();
        for (String word : book.split(" ")) {
            dic.add(word);
        }
        return dic;
    }

    public boolean add(String word) {
        Dictionary current = this;
        for (int i = 0; i < word.length(); i++) {
            int asc = word.charAt(i);
            asc = validChar(asc);
            if (asc == -1) {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    System.out.println("Not valid letter in a word");
                    return false;
                }
            }
            if (current.child[asc - 97] == null) {
                current.child[asc - 97] = new Dictionary();
            }
                current = current.child[asc - 97];
         

            if (i == word.length() - 1) {
                current.data++;
            }
        }
        return true;
    }

    public int frequencyOnBookOf(String word) {
        Dictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            int asc = (int) word.charAt(i);
            asc = validChar(asc);
            if (cur.child[asc - 97] == null) {
                return 0;
            } else {
                cur = cur.child[asc - 97];
            }
            if (i == word.length() - 1) {
                return cur.data;
            }
        }
        return 0;
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

}
