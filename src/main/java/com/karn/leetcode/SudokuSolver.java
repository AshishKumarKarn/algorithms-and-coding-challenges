package com.karn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SudokuSolver {
    public static void main(String[] args) {
        String[][] boardStrings = {
                {".", ".", "1", ".", ".", "4", "8", ".", "."},
                {".", ".", "3", "2", "8", ".", ".", ".", "5"},
                {".", "2", ".", ".", ".", "6", ".", ".", "."},
                {".", ".", "5", ".", ".", ".", ".", "7", "."},
                {".", "3", ".", "9", "1", ".", "6", ".", "."},
                {".", ".", ".", ".", ".", "2", ".", ".", "."},
                {".", "9", ".", "8", "3", ".", "1", ".", "."},
                {"1", ".", ".", ".", ".", ".", ".", ".", "6"},
                {".", ".", ".", ".", "4", ".", ".", ".", "."}
        };
        char[][] board = new char[boardStrings.length][boardStrings[0].length];
        for (int i = 0; i < boardStrings.length; i++) {
            for (int j = 0; j < boardStrings[i].length; j++) {
                board[i][j] = boardStrings[i][j].charAt(0);
            }
        }
        new SudokuSolver().solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    static class Range {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    private static final Map<Integer, Range> RANGE = new HashMap<>();

    static {
        RANGE.put(0, new Range(0, 2));
        RANGE.put(1, new Range(3, 5));
        RANGE.put(2, new Range(6, 8));
    }

    public void solveSudoku(char[][] board) {
        while (true) {
            int[] location = emptyLocation(board);
            if (location == null) break;
            int i = location[0];
            int j = location[1];
            boolean placed = false;
            for (int k = 1; k <= 9; k++) {
                if (validPosition(k, i, j, board)) {
                    board[i][j] = (char) (k + '0');
                    stack.push(new Element(k, i, j));
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                //backtrack
                while (!stack.isEmpty()) {
                    Element lastElement = stack.pop();
                    if (lastElement.number == 9) {
                        board[lastElement.i][lastElement.j] = '.';
                        continue;
                    }
                    int lastNumber = lastElement.number;
                    lastNumber++;//lastNumber can't increase more than 9
                    boolean validNumber = true;
                    board[lastElement.i][lastElement.j] = '.';
                    while (!validPosition(lastNumber, lastElement.i, lastElement.j, board)) {
                        if (lastNumber == 9) {
                            validNumber = false;
                            break;
                        }
                        lastNumber++;
                    }
                    if (validNumber) {
                        board[lastElement.i][lastElement.j] = (char) ('0' + (lastNumber));
                        lastElement.number = lastNumber;
                        stack.push(lastElement);
                        break;
                    }
                }
            }
        }

    }


    class Element {
        int number;
        int i;
        int j;

        public Element(int number, int i, int j) {
            this.number = number;
            this.i = i;
            this.j = j;
        }
    }

    private final Stack<Element> stack = new Stack<>();

    private boolean validPosition(int number, int i, int j, char[][] board) {
        return !isNumberInCurrentRowOrColumn(number, i, j, board) &&
                !isNumberInCurrentSubSquare(number, i, j, board);
    }


    private int[] emptyLocation(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isNumberInCurrentSubSquare(int number, int row, int col, char[][] board) {
        Range rowRange = RANGE.get(row / 3);
        Range colRange = RANGE.get(col / 3);
        for (int i = rowRange.start; i <= rowRange.end; i++) {
            for (int j = colRange.start; j <= colRange.end; j++) {
                if ((board[i][j] - '0') == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNumberInCurrentRowOrColumn(int number, int row, int col, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (number == (board[i][col] - '0')) {
                return true;
            }
        }
        for (int i = 0; i < board[row].length; i++) {
            if (number == (board[row][i] - '0')) {
                return true;
            }
        }
        return false;
    }
}
