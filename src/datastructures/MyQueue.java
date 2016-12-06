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
public class MyQueue implements MyArray {

    int queue[];
    int posPush, posPop;
    boolean empty;

    public MyQueue(int size) {
        queue = new int[size];
        posPop = 0;
        posPush = 0;
        empty = true;
    }

    public boolean push(int value) {
        if (posPush - posPop == 0) {
            if (!empty) {
                return false;
            }
        }
        queue[posPush++] = value;
        posPush %= queue.length;
        if (posPush - posPop != 0) {
            empty = false;
        }
        return true;
    }

    public int pop() {
        if (empty) {
            return Integer.MAX_VALUE;
        }
        int popped = queue[posPop++];
        posPop %= queue.length;
        if (posPush - posPop == 0) {
            empty = true;
        }
        return popped;
    }

    public int peek() {
        if (empty) {
            return Integer.MAX_VALUE;
        }

        return queue[posPop];
    }

    @Override
    public void print() {
        int pop = posPop;
        int push = posPush;
        StringBuilder p = new StringBuilder();

        if (!empty) {
            p.append( queue[pop]);
            pop = (pop + 1) % queue.length;
            while (pop - push != 0) {
                p.append(" - " + queue[pop]);
                pop = (pop + 1) % queue.length;
            }

        } else {
            p.append("Empty");
        }
        System.out.println(p.toString());
    }

}
