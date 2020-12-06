/* 
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int count = 0;
    // traverse 2d array
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        //
        if (grid[row][col] == '1') {
          count += 1;
          dfs(grid, row, col);

        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, int row, int col) {
    // boundary check
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0')
      return;

    grid[row][col] = '0'; // '1' seen, set it to '0'
    dfs(grid, row - 1, col); // check up
    dfs(grid, row + 1, col); // check down
    dfs(grid, row, col - 1); // check left
    dfs(grid, row, col + 1); // check right
  }
}
