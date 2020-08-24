/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[] right=new int[len];
        int max=Integer.MIN_VALUE;
        int val=0;
        for(int i=len-1;i>=0;i--){
            max=Math.max(max,prices[i]);
            val=Math.max(max-prices[i],val);
            right[i]=val;
        }
        max=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<len;i++){
            max=Math.min(max,prices[i]);
            if(i<len-1)
                res=Math.max(res,prices[i]-max+right[i+1]);
            else
                res=Math.max(res,prices[i]-max);
        }
        return res;
    }
}