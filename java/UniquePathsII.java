public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int[][] sum = new int[obstacleGrid.length][obstacleGrid[0].length];
        sum[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j=1; j<obstacleGrid[0].length; j++) {
            sum[0][j] = obstacleGrid[0][j] == 1 ? 0 : sum[0][j-1];
        }
        
        for (int i=1; i<obstacleGrid.length; i++) {
            sum[i][0] = obstacleGrid[i][0] == 1 ? 0 : sum[i-1][0];
            for (int j=1; j<obstacleGrid[i].length; j++) {
                sum[i][j] = obstacleGrid[i][j] == 1 ? 0 : sum[i-1][j] + sum[i][j-1]; 
            }
        }
        return sum[obstacleGrid.length-1][obstacleGrid[0].length-1];
     }
}