package com.karn.faang.gfg;

import java.util.Scanner;

public class LargestSquareFormedInAMatrix {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j]= sc.nextInt();
                }
            }
            System.out.println(maxSquare(n, m, mat));
        }
    }
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    max = Math.max(max, calculateMaxWidth(i,j,mat,Math.min(mat.length-i,mat[i].length-j)));
                }
            }
        }
        return max;
    }
    static int calculateMaxWidth(int i, int j, int[][] mat, int max){
        for(int l=i;l<i+max;l++){
            for(int m=j;m<j+max;m++){
                if(mat[l][m]==0){
                    return calculateMaxWidth(i,j,mat, max-1);
                }
            }
        }
        return max;
    }
}
