package GraphPractice;

public class NumIsland {
  public static int numIslans(char[][] grid) {

    if (grid == null || grid.length == 0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length;
    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(grid, i, j, m, n);
        }
      }
    }
    return count;
  }

  private static void dfs(char[][] grid, int i, int j, int m, int n) {
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = '0'; // mark visited
    dfs(grid, i + 1, j, m, n);
    dfs(grid, i - 1, j, m, n);
    dfs(grid, i, j + 1, m, n);
    dfs(grid, i, j - 1, m, n);
  }

  public static void main(String[] args) {
    char[][] grid = {
        { '1', '1', '0', '0', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' }
    };

    System.out.println();
    System.out.println(" Number of island : " + numIslans(grid)); // output 3 here
  }
}
