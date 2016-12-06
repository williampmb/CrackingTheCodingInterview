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
public class BinaryNode {

    int data;
    BinaryNode left, right, parent;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public BinaryNode(int data) {
        this.data = data;
    }

    boolean insert(int value) {
        boolean success = false;
        
        if (value > data) {
            if (right == null) {
                right = new BinaryNode(value);
                right.parent = this;
                success = true;
            } else {
                success = right.insert(value);
            }
        } else if (value < data) {
            if (left == null) {
                left = new BinaryNode(value);
                left.parent = this;
                success = true;
            } else {
                success = left.insert(value);
            }
        }
        return success;
    }

    BinaryNode search(int value) {
        BinaryNode found = null;
        if (value == data) {
            found = this;
        } else if (value > data) {
            if (right != null) {
                found = right.search(value);
            }
        } else if (value < data) {
            if (left != null) {
                found = left.search(value);
            }
        }
        return found;
    }

    boolean delete(int value) {
        boolean success = false;
        if (value == data) {
            deleteNode();
            success = true;
        } else if (value > data) {
            if (right != null) {
                success = right.delete(value);
            }
        } else if (value < data) {
            if (left != null) {
                success = left.delete(value);
            }
        }
        return success;
    }

    private void deleteNode() {
        if (right == null && left == null) {
            if (parent.right != null && parent.right.equals(this)) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } else if (right == null) {
            if (parent.right != null && parent.right.equals(this)) {
                parent.right = left;
                left.parent = parent;
            } else {
                parent.left = left;
                left.parent = parent;
            }
        } else if (left == null) {
            if (parent.right != null && parent.right.equals(this)) {
                parent.right = right;
                right.parent = parent;
            } else {
                parent.left = right;
                right.parent = parent;
            }
        } else {
            BinaryNode so = smallAtRight(right);
            copyNode(so, this);
            right.delete(data);
        }
    }

    private BinaryNode smallAtRight(BinaryNode so) {
        BinaryNode smallOne = so;
        while (smallOne.left != null) {
            smallOne = smallOne.left;
        }
        return smallOne;
    }

    private void copyNode(BinaryNode from, BinaryNode to) {
        to.setData(from.getData());
    }

    public String inOrder() {
        StringBuilder tree = new StringBuilder();
        if (left != null) {
            tree.append(left.inOrder());
        }
        tree.append(data + "-");

        if (right != null) {
            tree.append(right.inOrder());
        }
        return tree.toString();
    }

    int height() {
       int height = 0, heightLeft = 0, heightRight = 0;
        if (left != null) {
            heightLeft = left.height();
        }
        if (right != null) {
            heightRight = right.height();
        }
        int max = heightLeft > heightRight ? heightLeft : heightRight;
        height = max + 1;
        return height;
    }

}
