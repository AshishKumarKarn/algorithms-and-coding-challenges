package com.karn.algosolutions;

public class Nagarro_1 {
    static int N = 100050;

    static int[] lpf = new int[N];
    static int[] mobius = new int[N];

    static void least_prime_factor() {
        for (int i = 2; i < N; i++)
            if (lpf[i] == 0)
                for (int j = i; j < N; j += i)
                    if (lpf[j] == 0)
                        lpf[j] = i;
    }

    static void Mobius() {
        for (int i = 1; i < N; i++) {
            if (i == 1)
                mobius[i] = 1;
            else {
                if (lpf[i / lpf[i]] == lpf[i])
                    mobius[i] = 0;
                else
                    mobius[i] = -1 * mobius[i / lpf[i]];
            }
        }
    }

    static int gcd_pairs(int a[], int n) {
        int maxi = 0;

        int[] fre = new int[N];
        for (int i = 0; i < n; i++) {
            fre[a[i]]++;
            maxi = Math.max(a[i], maxi);
        }

        least_prime_factor();
        Mobius();

        // To store number of pairs with gcd equals to 1
        int ans = 0;

        // Traverse through the all possible elements
        for (int i = 1; i <= maxi; i++) {
            if (mobius[i] == 0)
                continue;

            int temp = 0;
            for (int j = i; j <= maxi; j += i)
                temp += fre[j];

            ans += temp * (temp - 1) / 2 * mobius[i];
        }

        // Return the number of pairs
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 3;
        int sqr = (n - 1) << 1;
        int[] arr = new int[sqr];
        for (int i = 0; i < sqr; i++) {
            arr[i]=i;
        }
        System.out.print(gcd_pairs(arr, sqr));
    }
}
