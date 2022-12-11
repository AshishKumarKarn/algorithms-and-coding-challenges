package com.karn.leetcode;



import java.util.*;

public class SpiralMatrix_Alternative {
    private int numberOfElements;
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length<1||matrix[0].length<1){
            return new ArrayList<>();
        }
        numberOfElements = matrix.length*matrix[0].length;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        Set<String> visited=new HashSet<>();
        visited.add("0_0");
        return spiralOrderPrint(0,1,matrix, Direction.RIGHT, result,visited);
    }

    private List<Integer> spiralOrderPrint(int i, int j, int[][] matrix, Direction direction,List<Integer> result,Set<String> visited) {
        if(result.size()==numberOfElements){
            return result;
        }
        if(i>= matrix.length||i<0||j<0||j>=matrix[i].length||visited.contains(i+"_"+j)){
            //go a step back according to current direction and call again after changing direction
            switch (direction){
                case RIGHT -> spiralOrderPrint(i+1,j-1,matrix,Direction.DOWN,result,visited);
                case DOWN -> spiralOrderPrint(i-1,j-1,matrix,Direction.LEFT,result,visited);
                case LEFT -> spiralOrderPrint(i-1,j+1,matrix,Direction.UP,result,visited);
                case UP -> spiralOrderPrint(i+1,j+1,matrix,Direction.DOWN,result,visited);
            }
        }else{
            visited.add(i+"_"+j);
            result.add(matrix[i][j]);
            switch (direction){
                case RIGHT -> spiralOrderPrint(i,j+1,matrix,Direction.RIGHT,result,visited);
                case DOWN -> spiralOrderPrint(i+1,j,matrix,Direction.DOWN,result,visited);
                case LEFT -> spiralOrderPrint(i,j-1,matrix,Direction.LEFT,result,visited);
                case UP -> spiralOrderPrint(i-1,j,matrix,Direction.UP,result,visited);
            }
        }
        return result;
    }

    enum Direction{
        RIGHT,DOWN,LEFT,UP
    }
}
