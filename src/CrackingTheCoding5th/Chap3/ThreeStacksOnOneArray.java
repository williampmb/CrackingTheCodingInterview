/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap3;

/**
 *
 * @author William
 */
public class ThreeStacksOnOneArray {
    int[] array;
    int[] pos;
    int arraySize;
    int spacePerStack;
    
    public ThreeStacksOnOneArray(int numOfStacks, int arraySize){
        this.arraySize = arraySize;
        array = new int[arraySize];
        pos = new int[numOfStacks];
        spacePerStack =  arraySize/numOfStacks;
    }
    
    public void push(int numStack, int value){
        if(pos[numStack]> (numStack)*(spacePerStack-1)){
            System.out.println("Erro: ");
            System.exit(1);
        }
        array[pos[numStack]] = value;
        pos[numStack]++;
    }
    
    public int pop(int numStack){
        if(pos[numStack]-- < (numStack-1)*(spacePerStack)){
            System.out.println("Erro: ");
            System.exit(1);
        }
        pos[numStack]++;
        return array[pos[numStack]];
    }
}
