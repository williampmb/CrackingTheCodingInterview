/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author William
 */
public class MyStack implements MyArray {

    int stack[];
    int stackPos;

    public MyStack(int size) {
        stack = new int[size];
        stackPos = 0;
    }

    public boolean push(int value) {
        if (stackPos == stack.length) {
            return false;
        }
        stack[stackPos++] = value;
        return true;
    }

    public int pop() {
        if (stackPos == 0) {
            return Integer.MAX_VALUE;
        }
        return stack[--stackPos];
    }

    public int peek() {
        if (stackPos == 0) {
            return Integer.MAX_VALUE;
        }
        return stack[stackPos - 1];
    }

    @Override
    public void print() {
        int pop = stackPos;
        StringBuilder p = new StringBuilder();
        if (pop == 0) {
            p.append("empty");
        } else {
            p.append(stack[--pop]);
            while (pop != 0) {
                p.append(" - " + stack[--pop]);
            }
        }
        p.append("\n");
        System.out.print(p.toString());
    }
}
