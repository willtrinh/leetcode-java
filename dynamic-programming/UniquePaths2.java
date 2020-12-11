/* 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.

*/
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // obstacle at the start point, robot won't be able to make any move -> return 0
        if (obstacleGrid[0][0] == 1)
            return 0;
        // mark number of ways of reaching the starting cell = 1
        obstacleGrid[0][0] = 1;
        // assign row and column
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        // filling the values for the first column
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        // filling the values for the first row
        for (int i = 1; i < col; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        // fill up the values starting from cell (1,1)
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // if not obstacle then num of ways of reaching cell[i][j] = its above cell +
                // its left cell
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
                // if obstacle, set the cell to 0
                else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        // return value stored in the rightmost bottommost cell, which is the finish
        // point
        return obstacleGrid[row - 1][col - 1];
    }
}
