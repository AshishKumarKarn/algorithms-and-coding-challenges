package com.karn.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class Epam1 {

    /**
     * Input => "1a*9", "3be*22","ps10*r271
     *
     * Output => "1a109" and other strings
     * */

    public static void main(String[] args) {
//        MyFunctional fun = (a,b)-> a*b;
//        int res=fun.multiply(2,3);
//        System.out.println(res);
        // fargate and lambda, AWS
        // basic circuit ,API rate limit,

        // Completable Future vs Future, Executor framework
        // PowerMockito, Microservices Design pattern(Circuit Breaker). AWS services
        // CAP theorem, SOLID -> LSP explanation
        // Prototype design pattern real life example, when will you implement it on what requirement
        //
        //
        System.out.println(modify("ps10*r271"));
    }
    public static String modify(String str){

        //---> backend give 401
        //ui-> /refresh  authorization {refreshToken}
        //newJWTToken and refresh
        String[] strs = str.split("");
        List<String> numberAsString = new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            int character = str.charAt(i)-'0';
            if(character>=0&&character<=9){
                sb.append(strs[i]);
            }else{
                if(sb.length()>0){
                    numberAsString.add(sb.toString());
                    sb=new StringBuilder();
                }
            }
        }
        if(sb.length()>0){
            numberAsString.add(sb.toString());
        }
        int total=0;
        for(String st:numberAsString){
            total += Integer.parseInt(st);
        }
        return str.replace("*", String.valueOf(total));
    }
}
@FunctionalInterface
interface MyFunctional{

    int multiply(int a,int b);

}
