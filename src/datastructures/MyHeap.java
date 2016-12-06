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
public class MyHeap {

    int heap[];
    int pos;
    int dnary; //how many childs it will have each
    int order;

    public MyHeap(int nChild) {
        if (nChild > 1) {
            heap = new int[nChild + 2];
            dnary = nChild;
        } else {
            heap = new int[4];
            dnary = 2;
        }
        pos = 1;
        order = 2;
    }

    public void insert(int v) {
        if (pos == heap.length) {
            createSpace();
        }
        heap[pos] = v;
        checkPriority(pos);
        pos++;
    }

    private void createSpace() {
        int[] h = new int[heap.length + ((int) Math.pow(dnary, order))];
        order++;
        for (int i = 1; i < heap.length; i++) {
            h[i] = heap[i];
        }
        heap = h;
    }

    private void checkPriority(int pos) {
        if (pos == 1) {
            return;
        }
        int idParent = (pos + (dnary - 2)) / dnary;
        if (heap[pos] < heap[idParent]) {
            int tmp = heap[pos];
            heap[pos] = heap[idParent];
            heap[idParent] = tmp;
            checkPriority(idParent);
        }
    }

    public int min() {

        if (pos == 1) {
            return Integer.MAX_VALUE;
        } else if (pos == 2) {
            return heap[--pos];
        }
        int min = heap[1];
        heap[1] = heap[--pos];
        checkPriorityChild(1);

        return min;
    }

    private void checkPriorityChild(int pos) {
        //this.pos - (int (Math.pow(dnary, order)));
        //FIX - stop parameter
        if(this.pos <pos){
            return;
        }
        int min = heap[pos];
        int posMin = pos;
        for (int i = -(dnary - 2); i < 2; i++) {
            if (min > heap[dnary * pos + i]) {
                min = heap[dnary * pos + i];
                posMin = dnary * pos + i;
            }
        }
        if (min == heap[pos]) {
            return;
        }
        int tmp = heap[pos];
        heap[pos] = min;
        heap[posMin] = tmp;
        checkPriorityChild(posMin);
    }

}
