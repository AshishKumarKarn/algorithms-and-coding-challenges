package com.karn.javatricks;

public class IterateMatrix {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},
                {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
                {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'i'},
                {'2', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},
                {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
                {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'i'},
                {'3', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},
                {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
                {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'i'}
        };

        for(int i=0;i<9;i++){
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<9;){
            for(int j=0;j<9;){
                System.out.print(board[i][j]);
                j++;
                if(j%3==0){
                    System.out.println();
                    i++;
                    j=0;
                }
                if(i%3==0){
                    System.out.println();
                    j=j+3;
                }

            }
        }
    }
}
