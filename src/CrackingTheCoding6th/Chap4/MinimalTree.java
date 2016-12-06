/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding6th.Chap4;

import datastructures.*;

/**
 *
 * @author William
 */
public class MinimalTree {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        BinarySearchTree tree = minimalHeight(array);
        int height = tree.height();
        System.out.println(height);
    }

    public static BinarySearchTree minimalHeight(int[] array) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNode root = addSortedArrayMinimalHeight(array, 0, array.length - 1);
        tree.setRoot(root);
        return tree;
    }

    private static BinaryNode addSortedArrayMinimalHeight(int[] array, int start, int end) {
        if (start > end || end > array.length - 1) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode root = new BinaryNode(array[mid]);
        if (start != end) {
            root.setRight(addSortedArrayMinimalHeight(array, mid + 1, end));
            root.setLeft(addSortedArrayMinimalHeight(array, start, mid - 1));
        }

        return root;

    }
}
