/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400
*/

/*Recursive & Memoization*/
class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        int len=nums.length;
        dp=new Integer[len];
        return dfs(nums,len-1);
    }
    
    public int dfs(int[] nums,int start){
        if(start<0)
            return 0;
        if(dp[start]!=null)
            return dp[start];
        dp[start]=Math.max(nums[start]+dfs(nums,start-2),dfs(nums,start-1));
        return dp[start];
    }
}


/*Iterative*/
class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        int len=nums.length;
        int res=0;
        
        dp=new Integer[len];
        for(int i=0;i<len;i++){
            if(i==0)
                dp[i]=nums[i];
            else if(i==1)
                dp[i]=Math.max(nums[0],nums[1]);
            else
                dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return len==0?0:dp[len-1];
    }
}
