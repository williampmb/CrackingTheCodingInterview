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
public class BinarySearchNode {

    int data;
    BinarySearchNode left;
    BinarySearchNode right;
    BinarySearchNode parent;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchNode left) {
        this.left = left;
    }

    public BinarySearchNode getRight() {
        return right;
    }

    public void setRight(BinarySearchNode right) {
        this.right = right;
    }

    public BinarySearchNode getParent() {
        return parent;
    }

    public void setParent(BinarySearchNode parent) {
        this.parent = parent;
    }

    public BinarySearchNode(int data) {
        this.data = data;
    }

    boolean insert(int value) {
        boolean success = false;

        if (value > data) {
            if (right == null) {
                right = new BinarySearchNode(value);
                right.parent = this;
                success = true;
            } else {
                success = right.insert(value);
            }
        } else if (value < data) {
            if (left == null) {
                left = new BinarySearchNode(value);
                left.parent = this;
                success = true;
            } else {
                success = left.insert(value);
            }
        }
        return success;
    }

    BinarySearchNode search(int value) {
        BinarySearchNode found = null;
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
            BinarySearchNode so = smallAtRight(right);
            copyNode(so, this);
            right.delete(data);
        }
    }

    private BinarySearchNode smallAtRight(BinarySearchNode so) {
        BinarySearchNode smallOne = so;
        while (smallOne.left != null) {
            smallOne = smallOne.left;
        }
        return smallOne;
    }

    private void copyNode(BinarySearchNode from, BinarySearchNode to) {
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

    boolean isBalanced() {
        boolean balanced = true;
        int leftHeight = 0, rightHeight = 0;
        if (left != null) {
            leftHeight = left.height();
        }
        if (right != null) {
            rightHeight = right.height();
        }
        int dif = leftHeight - rightHeight;

        if (dif != 0 && dif != 1 && dif != -1) {
            balanced = false;
        } else {
            if (left != null) {
                balanced = left.isBalanced();

            }
            if (balanced && right != null) {
                balanced = right.isBalanced();
            }

        }
        return balanced;
    }

}
