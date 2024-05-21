package com.karn.dsa.abdulbhari;

import java.util.Arrays;

public class PrimsAlgorithm {

    static int I = Integer.MAX_VALUE;
    static int[][] costAdjacencyMatrix = {
                    //0, 1, 2, 3, 4, 5, 6, 7
            /*0*/    {I, I, I, I, I, I, I, I},
            /*1*/    {I, I, 25, I, I, I, 5, I},
            /*2*/    {I, 25, I, 12, I, I, I, 10},
            /*3*/    {I, I, 12, I, 8, I, I, I},
            /*4*/    {I, I, I, 8, I, 16, I, 14},
            /*5*/    {I, I, I, I, 16, I, 10, 18},
            /*6*/    {I, 5, I, I, I, 10, I, I},
            /*7*/    {I, I, 10, I, 14, 18, I, I}

    };
    static int[][] TREE = new int[2][6];//2,|V|-1
    static int[] NEAR = new int[8];// 1 to 7 vertex, index 0 will not be used

    public static void main(String[] args) {
        int min = I, u = 0, v = 0;
        int totalCost = 0;

        /**
         * Finding minimum cost edge and saving the indices (vertices) for the edge
         * */
        for (int i = 0; i < costAdjacencyMatrix.length; i++) {
            for (int j = i; j < costAdjacencyMatrix[i].length; j++) {
                if (costAdjacencyMatrix[i][j] < min) {
                    min = costAdjacencyMatrix[i][j];
                    u = i;
                    v = j;
                }
            }
        }

        /**
         * storing the first edge with minimum cost in 2d array
         *
         *    | 1 |  |  |  |  |  |
         *    | 6 |  |  |  |  |  |
         *
         * */
        TREE[0][0] = u;
        TREE[1][0] = v;

        totalCost += min;

        /**
         * Initialize the NEAR array, the index with value u & v will be 0 representing visited.
         * */
        for (int i = 1; i < NEAR.length; i++) {
            if (i != u && i != v) {//we're not selecting index u and v as we want to set them to 0.
                if (costAdjacencyMatrix[i][u] < costAdjacencyMatrix[i][v]) {
                    NEAR[i] = u;
                } else {
                    NEAR[i] = v;
                }
            }
        }


        /**
         * This is repeated step where we find edge with minimum cost connected to spanning tree.
         * */
        for (int i = 1; i < TREE[0].length; i++) {
            min = I;
            int k = 0;
            for (int j = 1; j < NEAR.length; j++) {
                //if vertex is not visited
                if (NEAR[j] != 0) {
                    if (costAdjacencyMatrix[j][NEAR[j]] < min) {
                        min = costAdjacencyMatrix[j][NEAR[j]];
                        k = j;//nearest cost vertex from current connected spanning tree
                    }
                }
            }
            TREE[0][i] = k;
            TREE[1][i] = NEAR[k];
            NEAR[k] = 0;
            totalCost += min;
            for (int j = 1; j < NEAR.length; j++) {
                if (NEAR[j] != 0) {
                    if (costAdjacencyMatrix[j][NEAR[j]] > costAdjacencyMatrix[j][k]) {
                        NEAR[j] = k;
                    }
                }
            }
        }

        System.out.println(totalCost);
        System.out.println(Arrays.deepToString(TREE));

    }
}
