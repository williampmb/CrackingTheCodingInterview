/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding4th.structures;

/**
 *
 * @author William
 */
public class Tree {
    Tree left;
    Tree right;
    int data = Integer.MIN_VALUE;

    public Tree() {
        data = Integer.MIN_VALUE;
    }
    
    public void insert( int value){
       
        if(data == Integer.MIN_VALUE){
            left = new Tree();
            right = new Tree();
            data = value;
		
	}else if(value <= data){
		left.insert(value);
		
		
	}else if(value > data){
		right.insert(value);
		
		
	}
    
    }
    
    public static void printTreeOrdered(Tree root){
        if(root.data != Integer.MIN_VALUE){
            printTreeOrdered(root.left);
            System.out.println("-" + root.data +"-");
            printTreeOrdered(root.right);
        }
    }
    
    public void treeMinHeight(int[] values, int posIni, int posFin){
        
        if((posFin - posIni)== 2  ){
            this.insert(values[posIni]);
            this.insert(values[posFin-1]);
        } else if((posFin - posIni) == 1){
            this.insert(values[posIni]);
        }else{
            int mid = (posIni + posFin)/2;
            this.insert(values[mid]);
            treeMinHeight(values, posIni, mid);
            treeMinHeight(values, mid+1, posFin);
        }
    }
    
    public int height(){
        int h =0;
        if(data != Integer.MIN_VALUE){
            int l = left.height();
            int r = right.height();
            int max = (l>r) ? l: r;
            h = max + 1;
        }
        
        return h;
    }

    
}
