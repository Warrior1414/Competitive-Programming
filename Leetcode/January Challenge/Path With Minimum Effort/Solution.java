/*

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int r=heights.length;
        int c=heights[0].length;
        int[][] dp=new int[r][c];
        
        for(int i=0;i<r;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        pq.add(new int[]{0,0,0});
        dp[0][0]=0;
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            
            if(val[1]==r-1 && val[2]==c-1)
                return val[0];
            for(int[] d:dir){
                int nr=d[0]+val[1];
                int nc=d[1]+val[2];
                if(nr>=0 && nc>=0 && nr<r && nc<c){
                    int diff=Math.abs(heights[val[1]][val[2]]-heights[nr][nc]);
                    int temp=Math.max(val[0],diff);
                    if(temp<dp[nr][nc]){
                        dp[nr][nc]=temp;
                        pq.add(new int[]{temp,nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}