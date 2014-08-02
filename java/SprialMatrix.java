public class SprialMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        
        int[] xd = {0, 1, 0, -1};
        int[] yd = {1, 0, -1, 0};
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        flag[0][0] = true;
        order.add(matrix[0][0]);
        int direction = 0;
        int x = 0, y = 0;
        while (notFinished(flag, x, y)) {
            int tmpx = x + xd[direction];
            int tmpy = y + yd[direction];
            //use try catch to do out of boundry test
            try {
                if (!flag[tmpx][tmpy]) {
                    flag[tmpx][tmpy] = true;
                    order.add(matrix[tmpx][tmpy]);
                    x = tmpx;
                    y = tmpy;
                }
                else {
                    direction = (direction + 1) % 4;
                }
            }
            catch (Exception ex) {
                direction = (direction + 1) % 4;
            }
        }
        return order;
    }
    
    private boolean notFinished(boolean[][] flag, int x, int y) {
        int[] xd = {0, 1, 0, -1};
        int[] yd = {1, 0, -1, 0};
        for (int i=0; i<xd.length; i++) {
            int tmpx = x + xd[i];
            int tmpy = y + yd[i];
            //use try catch to do out of boundry test
            try {
                if (!flag[tmpx][tmpy]) {
                    return true;
                }
            }
            catch (Exception ex) {
                continue;
            }
        }
        return false;
    } 
}