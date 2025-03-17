/*Given two strings s1 and s2 and below operations that can be performed on s1. The task is to find the minimum number of edits (operations) to convert ‘s1‘ into ‘s2‘.  

Insert: Insert any character before or after any index of s1
Remove: Remove a character of s1
Replace: Replace a character at any index of s1 with some other character. */

class Test{

    static int editDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        //Create a table to store results of subproblem
        int[][] dp = new int[m +1][n +1];

        //Fill the known entries in dp[][]
        //If one string is empty , them answere is length of the other string

        for(int i=0; i<= m; i++) dp[i][0] = i;
        for(int j =0; j<= n; j++) dp[0][j] = j;

        //Fill the rest of dp[][]
        for(int i =1; i<= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) 
                    dp[i][j] = dp[i -1][j -1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j -1],dp[i -1][j]),dp[i -1][j -1]);
            }
           
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcfe";

        System.out.println(editDistance(s1,s2));
    }
}