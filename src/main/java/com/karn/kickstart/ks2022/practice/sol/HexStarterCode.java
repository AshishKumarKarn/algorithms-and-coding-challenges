package com.karn.kickstart.ks2022.practice.sol;

import java.util.Scanner;

/**
 * Starter code for the Kick Start 2022 problem Hex.
 */
public class HexStarterCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of test cases.
        int t = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
            // Read the board size.
            int n = scanner.nextInt();
            // Read each row of the board.
            char[][] board = new char[n][];
            for (int i = 0; i < n; i++) {
                board[i] = scanner.next().toCharArray();
            }

            // Determine the game status and display it.
            String status = determineStatus(board);
            System.out.println("Case #" + caseIndex + ": " + status);
        }
    }

    /**
     * Returns a status string as specified by the Hex problem statement.
     */
    static String determineStatus(char[][] board) {
        int redCount = 0;
        int blueCount = 0;

        int blueWinCount = 0;
        int redWinCount = 0;
        for (int i = 0; i < board.length; i++) {
            boolean redWin = true;
            boolean blueWin = true;
            //since NxN so, j-> board.length and not board[i].length
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'R') {
                    ++redCount;
                }
                if(board[j][i]!='R'){
                    redWin = false;
                }
                if (board[i][j] == 'B') {
                    ++blueCount;
                }
                if(board[i][j] != 'B'){
                    blueWin = false;
                }
            }
            if (blueWin) {
                ++blueWinCount;
            }
            if (redWin) {
                ++redWinCount;
            }
        }


        if (Math.abs(redCount - blueCount) > 1||redWinCount>1||blueWinCount>1) {
            return "Impossible";
        }


        //impractical scenario
        if(redWinCount == 1 && blueWinCount == 1){
            if(redCount>blueCount){
                return "Red wins";
            }else if(redCount<blueCount){
                return "Blue wins";
            }else{
                return "Impossible";
            }
        }
        if(redWinCount==1){
            return "Red wins";
        }
        if(blueWinCount==1){
            return "Blue wins";
        }
        return "Nobody wins";
    }
}
