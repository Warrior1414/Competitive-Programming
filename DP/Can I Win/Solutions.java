/*
In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.

Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise return false. Assume both players play optimally.

 

Example 1:

Input: maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
Example 2:

Input: maxChoosableInteger = 10, desiredTotal = 0
Output: true
Example 3:

Input: maxChoosableInteger = 10, desiredTotal = 1
Output: true
 

Constraints:

1 <= maxChoosableInteger <= 20
0 <= desiredTotal <= 300
*/

class Solution {
    Map<Integer,Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        map=new HashMap();
        if(desiredTotal==0)
            return true;
        int sum=(maxChoosableInteger*(maxChoosableInteger+1))/2;
        if(sum<desiredTotal)
            return false;
        return !dfs(maxChoosableInteger,desiredTotal,0);
            
    }
    
    public boolean dfs(int m,int d,int num){
        if(d<=0)
            return true;
        if(map.get(num)!=null)
            return map.get(num);
        boolean ret=true;
        int asol=num;
        for(int i=1;i<=m;i++){
            if((num & (1<<(i-1)))!=0)
                continue;
            num=num|(1<<(i-1));
            if(dfs(m,d-i,num)){
                ret=false;
                break;
            }
            num=num^(1<<(i-1));
        }
        map.put(asol,ret);
        return ret;
    }
}
