/*There are n stairs, and a person standing at the bottom wants to climb stairs to reach the top. The person can climb either 1 stair or 2 stairs at a time, the task is to count the number of ways that a person can reach at the top */

class Test{

    static int countWays(int n){
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i<= n; i++){
            dp[i] = dp[i -1] + dp[i -2];
        }

        return dp[n];
    }
     public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
     }

     //Time Complexity o(n) and space o(n)
}