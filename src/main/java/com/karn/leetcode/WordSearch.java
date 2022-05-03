package com.karn.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//todo: unresolved
public class WordSearch {

    public static void main(String[] args) {
        char[][] array = {
                {'c', 'a', 'a'},
                {'a', 'a', 'a'},
                {'b', 'c', 'd'}};
        boolean word = new WordSearch().exist(array, "aab");
        System.out.println(word);
    }

    public boolean exist(char[][] board, String word) {
        int i = 0, j = 0;
        char searchChar = word.charAt(0);
        while (true) {

            if (i == board.length) {
                break;
            }

            if (board[i][j] == searchChar) {
                Stack<String> visited = new Stack<>();
                if (findWord(board, i, j, word, 0, visited)) {
                    return true;
                }
            }

            if (j == board[i].length - 1) {
                //reset column location
                j = -1;
                //go to next row
                i++;
            }
            j++;
        }
        return false;
    }



    private boolean findWord(char[][] board, int i, int j, String word, int count,Stack<String> visited) {
        if (count == word.length()) {
            return true;
        }
        if (i == board.length || i < 0 || j == board[i].length || j < 0) {
            visited.pop();
            return false;
        }
        String key = i + "_" + j;
        if (board[i][j] == word.charAt(count) && !visited.contains(key)) {
            visited.add(key);
            count++;
            boolean u= findWord(board, i - 1, j, word, count,visited) ;
            boolean d=       findWord(board, i + 1, j, word, count,visited);
            boolean l=       findWord(board, i, j - 1, word, count,visited) ;
            boolean r=      findWord(board, i, j + 1, word, count,visited);
            if(l||r||u||d){
                return true;
            }
        }
        visited.pop();
        return false;
    }

    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
    //"ABCESEEEFS"

}
