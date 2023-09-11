package com.karn.leetcode;

import java.util.Stack;

public class AsteroidsCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.add(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            if(asteroids[i]<0){
                int val = -asteroids[i];//positive
                Integer last = null;
                if(!stack.isEmpty())
                 last = stack.pop();
                boolean vanished = false;
                while(last!=null&&last>0){
                    if(last>val){
                        stack.add(last);
                        vanished = true;
                        break;
                    }else if(last==val){
                        vanished = true;
                        break;
                    }else{
                        last = stack.pop();
                    }
                }
                if(!vanished){
                    if(last!=null)
                        stack.add(last);
                    stack.add(asteroids[i]);
                }
            }else{
                stack.add(asteroids[i]);
            }
        }
        return stack.stream().mapToInt(a->a).toArray();
    }
}
