//Fibonacci Using Memoization(Top-Down)

import java.util.Arrays;

class Test{
    static int nthFibonacci(int n, int[] memo){

        //Base Case
        if(n <= 1){
            return n;
        }

        //Check if result is in the memo table
        if(memo[n] != -1){
            return memo[n];
        }

        //Recursion case: Calculate Fibonacci number and store it in memo
        memo[n] = nthFibonacci(n-1, memo) + nthFibonacci(n-2, memo);

        return memo[n];
    }

    static int nthFibonacci(int n){

        //Create a memoization table and initialize with -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        //Call the utilization function
        return nthFibonacci(n, memo);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }
}