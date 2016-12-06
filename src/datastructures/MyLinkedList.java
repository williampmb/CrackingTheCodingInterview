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
public class MyLinkedList {

    int data;
    MyLinkedList next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyLinkedList getNext() {
        return next;
    }

    public void setNext(MyLinkedList next) {
        this.next = next;
    }

    public MyLinkedList(int v) {
        data = v;
    }

    public int size() {
        int size = 1;
        MyLinkedList end = next;
        while (end != null) {
            size++;
            end = end.next;
        }
        return size;
    }

    public boolean add(int v) {
        MyLinkedList clone = new MyLinkedList(data);
        clone.next = next;
        next = clone;
        this.data = v;
        return true;
    }

    public boolean addTail(int v) {
        MyLinkedList end = this;
        while (end.next != null) {
            end = end.next;
        }
        MyLinkedList add = new MyLinkedList(v);
        end.next = add;
        return true;
    }

    public boolean addAtIndex(int v, int index) {
        int count = 0;
        MyLinkedList at = this;
        if (index == 0) {
            add(v);
            return true;
        }
        while (index != count && at.next != null) {
            count++;
            if (count == index) {
                break;
            }
            at = at.next;
        }

        if (index == count) {
            at.add(v);

        } else {
            MyLinkedList add = new MyLinkedList(v);
            at.next = add;

        }
        return true;
    }

    public MyLinkedList search(int v) {
        MyLinkedList search = this;
        while (search != null) {
            if (search.data == v) {
                return search;
            }
            search = search.next;
        }
        return null;
    }

    public boolean remove(int v) {
        MyLinkedList rem = this;
        if (rem.data == v) {
            rem.data = rem.next.data;
            rem.next = rem.next.next;
            return true;
        }
        while (rem.next != null) {
            if (rem.next.data == v) {
                rem.next = rem.next.next;
                return true;
            }
            rem = rem.next;
        }
        //not found the value v
        return false;
    }

    public void print() {
        StringBuilder mllPrint = new StringBuilder();
        MyLinkedList mll = this;
        mllPrint.append(data);

        while (mll.next != null) {
            mllPrint.append(" -> " + mll.next.data);
            mll = mll.next;
        }
        System.out.println(mllPrint.toString());
    }
}
