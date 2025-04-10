//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

class Test{

    static int rob(int[] nums){

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i< nums.length; i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i -2]);
        }

         return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};

        System.out.println("Robbed 1 :"+ rob(nums1));
        System.out.println("Robbed 2 :"+ rob(nums2));
    }
}