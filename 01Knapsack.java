/*Given n items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. */

import java.util.*;

class Test{

    static int knapsack(int W, int[] val, int[] wt){
        int n = wt.length;
        int[][] dp = new int[n +1][W + 1];

        //Building table dp[][] in a bottom-up manner
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){

                //If there is no item or the knapsack capacity is 0
                if(i == 0 || j == 0 ) dp[i][j] = 0;
                else{
                   int pick = 0;
                   int notPick = 0;

                   //Pick ith item if it does not exceed the capacity of knapsack

                   if(wt[i - 1] <= j){
                    pick = val[i -1]+ dp[i -1][j - wt[i -1]];
                   } else{
                    notPick = dp[i -1][j];
                   }

                   
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
    }
     
    public static void main(String[] args) {
        int[] val = {1,2,3};
        int[] wt = {4,5,1};
        int W = 4;

        System.out.println(knapsack(W,val,wt));
    }
}