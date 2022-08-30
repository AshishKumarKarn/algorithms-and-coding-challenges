package com.karn.kickstart.ks2022.practice.season3;

import java.util.Scanner;

/** Starter code for the Kick Start 2022 problem "GBus count". */
public class GBusCountSolution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Read the number of test cases.
    int t = scanner.nextInt();
    for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
      // Read the GBus specifications.
      int n = scanner.nextInt();
      GBus[] gBuses = new GBus[n];
      int max = 0;
      for (int i = 0; i < n; i++) {
        int a = scanner.nextInt();
        max=Math.max(max,a);
        int b = scanner.nextInt();
        max = Math.max(max,b);
        gBuses[i] = new GBus(a,b);
      }
      // Read the city set P.
      int p = scanner.nextInt();
      int[] cities = new int[p];
      for (int i = 0; i < p; i++) {
        cities[i] = scanner.nextInt();
      }
      // Solve the test case.
      int[] counts = countBuses(gBuses, cities, max);
      // Format the output.
      StringBuffer countStringBuffer = new StringBuffer();
      for (int count : counts) {
        countStringBuffer.append(" " + count);
      }
      System.out.println("Case #" + caseIndex + ":" + countStringBuffer);
    }
  }

  /** Calculates how many GBuses serve each city. */
  static int[] countBuses(GBus[] gBuses, int[] cities, int max) {
    int[] arr = new int[max+1];
    int[] result = new int[cities.length];
    for (GBus bus: gBuses) {
      for (int i = bus.a; i <= bus.b; i++) {
        arr[i]++;
      }
    }
    for (int i = 0; i < cities.length; i++) {
      if(cities[i]>=0&&cities[i]<arr.length){
        result[i] = arr[cities[i]];
      }
    }
    return result;
  }

  /** Specifies the endpoints of a GBus route: the GBus serves cities A through B. */
  private static class GBus {
    /** Represents city A. */
    int a;
    /** Represents city B. */
    int b;

    GBus(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
}
