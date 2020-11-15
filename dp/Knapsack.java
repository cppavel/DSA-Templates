package com.company;

public class Knapsack {

    public static int max(int a, int b)
    {
        return a>b?a:b;
    }

    public static int knapsack(int[] w, int [] p, int m )
    {
        int[][] dp = new int[w.length+1][m+1];

        for(int i = 0; i < w.length + 1; i++)
        {
            dp[i][0]= 0;
        }

        for(int j =0; j < m + 1; j++)
        {
            dp[0][j] = 0;
        }

        for(int i = 1; i < w.length + 1; i++)
        {
            for(int j =1; j < m+1; j++)
            {
                if(j-w[i-1]>=0)
                {
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-w[i-1]] + p[i-1]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[w.length][m];
    }
}
