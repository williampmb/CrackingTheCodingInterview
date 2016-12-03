/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCoding5th.Chap1;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 *
 * @author William
 */
public class StringQt{
    
  
    

    
    //#1.7 Write an algorithm such that an element in a MxN matrix is 0 its entire row and column are set to 0
    
    public static void zeroColRow(int m[][]){
    	boolean[] cols = new boolean[m.length];
    	boolean[] rows = new boolean[m[0].length];
    	
    	for(int row = 0; row < rows.length; row++){
    		for(int col = 0; col < cols.length; col++){
    			if(m[row][col]==0){
    				cols[col] = true;
    				rows[row] = true;
    			}
    		}
    	}
    	
    	for(int i = 0; i < rows.length; i++){
    		if(rows[i]){
    			for(int j = 0; j < m[0].length; j++){
    				m[i][j] = 0;
    			}
    		}
    	}
    	
    	for(int i =0; i< cols.length; i++){
    		if(cols[i]){
    			for(int j=0; j<m.length; j++){
    				m[j][i] = 0;
    			}
    		}
    	}
    }
    
    static void printMatrix(int[][] m){
    	for(int row = 0; row < m.length; row++){
    		for(int col = 0; col < m[0].length; col++){
    			System.out.print(m[row][col]);
    		}
    		System.out.println("");
    	}
    }
}
