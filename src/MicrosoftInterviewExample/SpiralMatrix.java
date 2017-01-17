/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicrosoftInterviewExample;

/**
 *
 * @author William
 */
public class SpiralMatrix {
    
    public static void main(String[] args){
        //int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] a = {{1,2,3,4},{5,6,7,8}};
        int[][] a = {{1,2},{3,4},{5,6},{7,8}};
        spiralMatrix(a);
    }
    
    public static void spiralMatrix(int[][] a){
        printAround(0,0, a.length-1, a[0].length-1, a);
    }

    private static void printAround(int rowIni, int colIni, int rowEnd, int colEnd, int[][] a) {
       if(rowIni > rowEnd || colIni > colEnd) return;
       
       for(int i =colIni; i<colEnd+1; i++){
           System.out.println(a[rowIni][i]);
       }
       for(int i =rowIni+1; i<rowEnd+1; i++){
           System.out.println(a[i][colEnd]);
       }
       for(int i =colEnd-1; i>=colIni; i--){
           System.out.println(a[rowEnd][i]);
       }
       for(int i =rowEnd-1; i>=rowIni+1; i--){
           System.out.println(a[i][colIni]);
       }
       printAround(rowIni+1,colIni+1,rowEnd-1,colEnd-1,a);
    }

    
}
