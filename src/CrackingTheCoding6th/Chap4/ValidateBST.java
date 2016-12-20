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
public class ValidateBST {

    public static void main(String[] args) {

        BinaryNode a = new BinaryNode();
        a.setData(50);
        BinaryNode b = new BinaryNode();
        b.setData(48);
        BinaryNode c = new BinaryNode();
        c.setData(49);
        BinaryNode h = new BinaryNode();
        c.setData(55);

        a.setLeft(b);
        b.setRight(c);
        c.setRight(h);

        BinaryTree r = new BinaryTree();
        r.setRoot(a);
        boolean d = validateBST(r);
        System.out.println(d);

    }

    public static boolean validateBST(BinaryTree root) {
         boolean check = false;
        if (root.getRoot() != null) {
            if (root.getRoot().getLeft() != null) {
                check = validateBSTLeft(root.getRoot().getLeft(), Integer.MIN_VALUE, root.getRoot().getData());
                if (!check) {
                    return false;
                }
            }
            if (root.getRoot().getRight() != null) {
                check = validateBSTRight(root.getRoot().getRight(), root.getRoot().getData(), Integer.MAX_VALUE);
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateBSTRight(BinaryNode right, int min, int max) {
        boolean check = false;
        if (right.getData() > min && right.getData() < max) {
            if (right.getLeft() != null) {
                check = validateBSTLeft(right.getLeft(), min, right.getData());
                if (!check) {
                    return false;
                }
            }else{
                check = true;
            }
            if (right.getRight() != null) {
                check = validateBSTRight(right.getRight(), right.getData(), max);
            }else{
                check = true;
            }
        }
        return check;
    }

    private static boolean validateBSTLeft(BinaryNode left, int min, int max) {
        boolean check = false;
        if (left.getData() > min && left.getData() <= max) {
            if (left.getLeft() != null) {
                check = validateBSTLeft(left.getLeft(), min, left.getData());
                if (!check) {
                    return false;
                }
            }else{
                check = true;
            }
            if (left.getRight() != null) {
                check = validateBSTRight(left.getRight(), left.getData(), max);
            }else{
                check = true;
            }
        }
        return check;
    }

}
