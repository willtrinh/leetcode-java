/* 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
*/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // fill all column in first row with 1 (since we only have a single unique path
        // to reach those)
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // fill all rows in first column with 1 (reason same as above)
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        // iterate through matrix, starting with dp[1][1]
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // dp[i-1][j] = cell above
                // dp[i][j-1] = cell to the left
                // adding the sum of top cell and left cell give us the unique paths to reach
                // the current cell
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // last element in dp array is the total possible paths
        return dp[m - 1][n - 1];
    }
}
