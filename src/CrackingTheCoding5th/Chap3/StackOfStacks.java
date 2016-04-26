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
//TO FIX IT
public class StackOfStacks {

    StackImp[] stacks;
    int position;
    int maxStacks;
    int threshold;

    public StackOfStacks(int maxStacks, int threshold) {
        this.maxStacks = maxStacks;
        stacks = new StackImp[maxStacks];
        int iniStacks = 0;
        while (iniStacks < maxStacks) {
            stacks[iniStacks] = new StackImp(threshold);
            iniStacks++;
        }
        this.threshold = threshold;
        position = 0;
    }
    
    public int pop(){
        if(position <0){
            return Integer.MIN_VALUE;
        }
        if(stacks[position].position == 0){
            position--;
        }
        if(position <0){
            return Integer.MIN_VALUE;
        }
        return stacks[position].pop();
    }
    
    public void push(int value){
        if((stacks[position]).position == this.threshold){
            position++;
        }
        if(position == maxStacks){
            System.out.println("no room for more stacks");
        }
        stacks[position].push(value);
    }

}

class StackImp {

    int threshold;
    int[] elements;
    int position;

    StackImp(int threshold) {
        this.threshold = threshold;
        elements = new int[threshold];
        position = 0;
    }

    void push(int value) {
        if (position == threshold) {
            System.out.println("full");
        } else {
            elements[position] = value;
            position++;
        }
    }

    int pop() {
        if (position == 0) {
            System.out.println("empty");
            return 0;
        } else {
            position--;
            return elements[position];
        }
    }
}
