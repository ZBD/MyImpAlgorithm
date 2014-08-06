public class SurroundedRegions {
    int[] xd = {-1, 0 , 1 , 0 };
    int[] yd = {0, 1, 0, -1};
    int[][] flag;
    int width = 0;
    int height = 0;
    public void solve(char[][] board) {
        if (board == null) {
            //cannot return null, should use return 
            return;
        } 
        
        //check extreme board case
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        //use recursive way will stackover flow
        //to avoid this, use queue
        
        width = board[0].length;
        height = board.length;
        flag = new int[height][width];
        
        //must I init? No but better
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                flag[i][j] = 0;
            }
        }
        
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                //it is upcase X
                if (board[i][j] == 'X') {
                    flag[i][j] = 1;
                }
            }
        }
        
        //only check from the edges of the board
        //queue is abstract
        Queue<Integer> que = new LinkedList<Integer>();
        
        for (int i=0; i<height; i++) {
            if (flag[i][0] == 0) {
                //queue add poll peek
                que.add(i);
                que.add(0);
            }
            if (flag[i][width-1] == 0) {
                que.add(i);
                que.add(width-1);
            }
        }
        
        for (int i=0; i<width; i++) {
            if (flag[0][i] == 0) {
                que.add(0);
                que.add(i);
            }
            if (flag[height-1][i] == 0) {
                que.add(height-1);
                que.add(i);
            }
        }
        
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            if (flag[x][y] != 0) {
                continue;
            }
            
            int nx, ny;
            flag[x][y] = -1;
            for (int i=0; i<4; i++) {
                nx = x + xd[i];
                ny = y + yd[i];
                if (check(nx,ny)) {
                    que.add(nx);
                    que.add(ny);
                }
            }
        }
        
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (flag[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void bfs(int x, int y) {
        if (flag[x][y] != 0) {
            return;
        }
        
        int nx, ny;
        flag[x][y] = -1;
        for (int i=0; i<4; i++) {
            nx = x + xd[i];
            ny = y + yd[i];
            if (check(nx,ny)) {
                bfs(nx, ny);
            }
        }
    }
    
    public boolean check(int x, int y) {
        if (x < 0 || x >= height) {
            return false;
        } 
        else if (y < 0 || y >= width) {
            return false;
        }
        else if (flag[x][y] != 0) {
            return false;
        }
        return true;
    }
}