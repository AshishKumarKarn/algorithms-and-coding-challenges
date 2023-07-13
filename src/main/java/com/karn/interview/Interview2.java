package com.karn.interview;

import java.util.Arrays;

public class Interview2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotate(arr,1, Direction.RIGHT)));
    }

    /**
     * select E.emp_name, M.emp_name from Employees E, Employees M where E.manager_id= M.emp_id;
     *
     *users?id=1;
     * users/{id}
     * */
    private static int[] rotate(int[] arr, int k, Direction direction){
        int[] rotatedArray = new int[arr.length];
        k = k%arr.length;
        for (int i = 0; i < arr.length; i++) {
            if((i+k)>=arr.length && Direction.RIGHT == direction){
                int j=(i+k)-arr.length;
                rotatedArray[j]=arr[i];
            }else if(i-k<0 && Direction.LEFT == direction) {
                int j=arr.length-(k-i);
                rotatedArray[j]=arr[i];
            }else if(Direction.LEFT == direction){
                int j = i - k;
                rotatedArray[j] = arr[i];
            }else{
                int j = i + k;
                rotatedArray[j] = arr[i];
            }
        }
        return rotatedArray;
    }
    enum Direction{
        LEFT,RIGHT
    }
}
