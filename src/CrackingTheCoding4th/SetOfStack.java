/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th;

/**
 *
 * @author William
 */
public class SetOfStack {
    int threshold;
    LinkedListStack set;
    public SetOfStack(int threshold) {
        this.threshold = threshold;
        set = new LinkedListStack(threshold);
    }
    public void push(int value) {
        while (set.next != null)  set = set.next;
        if (set.pos == threshold-1) {
            set.next = new LinkedListStack(threshold);
            (set.next).previous = set;
            set = set.next;
        }
        set.pos++;
        set.array[set.pos] = value;
    }
    public int pop() {
        while (set.next != null) set = set.next;
        if (set.pos == -1) {
            if (set.previous == null)   System.exit(0);
            else {
                set = set.previous;
                set.next = null;
            }
        }
        set.pos--;
        return set.array[set.pos + 1];
    }

    private static class LinkedListStack {
        private LinkedListStack next;
        int pos;
        private LinkedListStack previous;
        private int[] array;
        private LinkedListStack(int threshold) {
            next = null;
            previous = null;
            pos = -1;
            array = new int[threshold];
        }
    }
}
