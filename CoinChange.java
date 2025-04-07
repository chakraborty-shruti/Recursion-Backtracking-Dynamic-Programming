//Given an integer array of coins[] of size n representing different types of denominations and an integer sum, the task is to count all combinations of coins to make a given value sum.  

//Note: Assume that you have an infinite supply of each type of coin. 

//Java program for coin change problem using tabulation

class Test{

    static int count(int[] coins, int sum){
        int n = coins.length;

        //2d dp array where n is the number of coin denominations and sum is the target sum
        int[][] dp = new int[n+1][sum+1];

        //Represent the base case where the target sum is 0, and there is only one way to make change: by not selecting any coin
        dp[0][0] = 1;

        for(int i =1; i<= n; i++){
            for(int j = 0; j <= sum; j++){

                //Add the number of ways to make change without using the current coin
                dp[i][j] += dp[i-1][j];

                if((j - coins[i - 1]) >= 0){

                    //Add the number of ways to make change using the current coin
                    dp[i][j] += dp[i][j - coins[i -1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        System.out.println(count(coins,sum));
    }
}