package com.karn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i==j){
                    if(!hasValidColumns(board,i,j)||!hasValidRows(board,i,j)){
                        return false;
                    }
                }
                if(i%3==0&&j%3==0){
                    if(!hasValidSubMatrix(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //for all left diagonal elements
    public boolean hasValidColumns(char[][] board, int i, int j) {
        Set<Character> memory = new HashSet<>();
        //traverse through current column
        for (int k = 0; k < board.length; k++) {
            if(memory.contains(board[k][j])){
                return false;
            }else if(board[k][j]!='.'){
                memory.add(board[k][j]);
            }
        }
        return true;
    }

    //for all left diagonal elements
    public boolean hasValidRows(char[][] board, int i, int j) {
        Set<Character> memory = new HashSet<>();
        //traverse through current row
        for (int k = 0; k < board[i].length; k++) {
            if(memory.contains(board[i][k])){
                return false;
            }else if(board[i][k]!='.'){
                memory.add(board[i][k]);
            }
        }
        return true;
    }

    //let's pick first value of each sub matrix
    public boolean hasValidSubMatrix(char[][] board, int i, int j) {
        Set<Character> memory = new HashSet<>();
        for (int k = i; k <= i+2; k++) {
            for (int l = j; l <= j+2 ; l++) {
                if(memory.contains(board[k][l])){
                    return false;
                }else if(board[k][l]!='.'){
                    memory.add(board[k][l]);
                }
            }
        }
        return true;
    }
}
