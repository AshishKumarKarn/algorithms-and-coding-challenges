package com.karn.algosolutions;

public class KnapSack01 {
    /**
     * Given a Knapsack/Bag with W weight capacity and a list of N items with given vi value and wi weight. Put these items in the knapsack in order to maximise the value of all the placed items without exceeding the limit of the Knapsack.
     * 0-1 Knapsack Problem
     * The problem remains the same but one cannot break the items you can either select it fully ( 1) or don’t select it (0 ).
     * */
     int knapSack(int W,int N,int v[],int w[]) {
        /* Base case 0 items left or knapsack is full */
        if(N == 0 || W == 0)
            return 0;
    /* if weight of current element is less than or equal to capacity we can
    either include or exclude the item. */
        if(w[N] <= W){
            return Math.max(v[N]+knapSack(W-w[N],N-1,v,w),knapSack(W,N-1,v,w));
        }
    /* if weight of current element is greater than the capacity we will
    not include it thus returning just the ignoring part. */
        return knapSack(W,N-1,v,w);
    }
}
