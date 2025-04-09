import java.util.Arrays;

class Test{

    static int minCoins(int[] coins, int W){
        int n = coins.length;
        int[][] dp = new int[n+1][W+1];

        //Initialize all cells with a large number
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1); //Use -1 to prevent overflow

        }

        //Base case: 0 coins are needed to make sum 0 
        for(int i =0; i <= n; i++){
            dp[i][0] = 0;
        }

        //Fill DP table
        for(int i =1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; //Don't take the coin

                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i -1]]);
                }
            }
        }

        int result = dp[n][W];
        if(result >= Integer.MAX_VALUE - 1){
            return -1; //Not possible to form the sum
        }else{
            return result; //Minimum nuber of coins needed
        }
    }

    public static void main(String[] args) {
        int[] coins = {9,6,5,1};
        int sum = 19;
        System.out.println(minCoins(coins,sum));
    }
}