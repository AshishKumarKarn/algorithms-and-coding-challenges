package com.karn.kickstart.ks2022.practice.season3;

import java.util.*;

public class WiggleWalk {
    private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
        Map<Integer,int[]> colMem = new HashMap<>();
        Map<Integer,int[]> rowMem = new HashMap<>();
        char[] insArr = instructions.toCharArray();
        colMem.put(Sc,new int[]{Sr,Sr});
        rowMem.put(Sr,new int[]{Sc,Sc});
        int[] finalPosition = new int[2];
        for (char c : insArr) {
            switch (c) {
                case 'E':
                    int[] colIJ = rowMem.get(Sr);
                    if(colIJ==null){
                        colIJ = new int[2];
                        Arrays.fill(colIJ, Sc);
                    }else{
                        ++colIJ[1];
                    }
                    Sc = colIJ[1];
                    rowMem.put(Sr,colIJ);

                    break;
                case 'W':
                    colIJ = rowMem.get(Sr);
                    if(colIJ==null){
                        colIJ = new int[2];
                        Arrays.fill(colIJ, Sc);
                    }else{
                        --colIJ[0];
                    }
                    Sc = colIJ[0];
                    rowMem.put(Sr,colIJ);
                    break;
                case 'N':
                    int[] rowIJ = colMem.get(Sc);
                    if(rowIJ==null){
                        rowIJ = new int[2];
                        Arrays.fill(rowIJ, Sr);
                    }else{
                        --rowIJ[0];
                    }
                    Sr = rowIJ[0];
                    colMem.put(Sc,rowIJ);
                    break;
                case 'S':
                    rowIJ = colMem.get(Sc);
                    if(rowIJ==null){
                        rowIJ = new int[2];
                        Arrays.fill(rowIJ, Sr);
                    }else{
                        ++rowIJ[1];
                    }
                    Sr = rowIJ[1];
                    colMem.put(Sc,rowIJ);
                    break;
            }
        }
        finalPosition[0]=Sr;
        finalPosition[1]=Sc;
        return finalPosition;
    }

//    private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
//        int[][] visited = new int[R][C];
//        Sr--;
//        Sc--;
//        visited[Sr][Sc] = 1;
//        int[] finalPosition = new int[2];
//        for (char dir : instructions.toCharArray()) {
//            switch (dir) {
//                case 'N':
//                    while (visited[Sr][Sc] == 1)
//                        Sr--;
//                    break;
//                case 'E':
//                    while (visited[Sr][Sc] == 1)
//                        Sc++;
//                    break;
//                case 'W':
//                    while (visited[Sr][Sc] == 1)
//                        Sc--;
//                    break;
//                case 'S':
//                    while (visited[Sr][Sc] == 1)
//                        Sr++;
//                    break;
//            }
////            shiftAndMarkVisited(visited, Sr, Sc, dir, finalPosition);
////            Sr = finalPosition[0];
////            Sc = finalPosition[1];
//            visited[Sr][Sc]=1;
//        }
//        finalPosition[0]=Sr+1;
//        finalPosition[1]=Sc+1;
//        return finalPosition;
//    }
//
//    private static void shiftAndMarkVisited(int[][] visited, int Sr, int Sc, char dir, int[] finalPosition) {
//        if (visited[Sr][Sc] == 1) {
//            switch (dir) {
//                case 'N':
//                    while (visited[Sr][Sc] == 1)
//                        Sr--;
//                    break;
//                case 'E':
//                    while (visited[Sr][Sc] == 1)
//                        Sc++;
//                    break;
//                case 'W':
//                    while (visited[Sr][Sc] == 1)
//                        Sc--;
//                    break;
//                case 'S':
//                    while (visited[Sr][Sc] == 1)
//                        Sr++;
//                    break;
//            }
//            shiftAndMarkVisited(visited, Sr, Sc, dir, finalPosition);
//        } else {
//            visited[Sr][Sc] = 1;
//            finalPosition[0] = Sr;
//            finalPosition[1] = Sc;
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int R = in.nextInt();
            int C = in.nextInt();
            int Sr = in.nextInt();
            int Sc = in.nextInt();
            String instructions = in.next();
            int[] ans = endPosition(N, R, C, Sr, Sc, instructions);
            System.out.println("Case #" + t + ": " + ans[0] + " " + ans[1]);
        }
    }
}



