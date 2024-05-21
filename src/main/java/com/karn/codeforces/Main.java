package com.karn.codeforces;

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t-->0)
	   
	   {
	       int n=sc.nextInt();
	           String s=sc.next();
	           int u=0,d=0;
	           for(char ch:s.toCharArray())
	           {
	               if(ch=='U')
	               {
	                   u++;
	               }else
	               {
	                   d++;
	               }
	           }
	           if(u%2!=0)
	           {
	               System.out.println("YES");
	           }else{
	               System.out.println("NO");
	           }
	   
	   }
	}
}
