
public class SudokuSolver {
	int width;
	int height;
	static int[] xd = {0,0,0,1,1,0,0,-1,0};
	static int[] yd = {0,1,1,0,0,-1,-1,0,1};

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		width = board[0].length;
		height = board.length;
		dfs(board, 0);
	}

	private boolean dfs(char[][] board, int n) {
		if (n == board.length * board[0].length) {
			return true;
		}

		int x = getX(n);
		int y = getY(n);
		if (board[x][y] != '.') {
			return dfs(board, n+1);
		}

		for (char i='1'; i<='9'; i++) {
			board[x][y] = i;
			if (check(board, n) && dfs(board, n+1)) {
				return true;
			}

		}
		//remember to restore '.'
		board[x][y] = '.';
		return false;
	}

	private int getX(int n) {
		return n/width;
	}

	private int getY(int n) {
		return n%width;
	}


	private boolean check3(char[][] board, int n) {
		int nx = getX(n);
		int ny = getY(n);
		int x = nx - nx % 3;
		int y = ny - ny % 3;
		for (int i=0; i<xd.length; i++) {
			x += xd[i];
			y += yd[i];
			if ((x != nx || y != ny) && board[x][y] == board[nx][ny]) {
				return false;
			}
		}
		return true;
	}

	private boolean checkRow(char[][] board, int n) {
		int row = getX(n);
		int y = getY(n);
		for (int i=0; i<width; i++) {
			if (i != y && board[row][i] == board[row][y]) {
				return false;
			}
		}
		return true;
	}

	private boolean checkCol(char[][] board, int n) {
		int col = getY(n);
		int x = getX(n);
		for (int i=0; i<height; i++) {
			if (i != x && board[i][col] == board[x][col]) {
				return false;
			}
		}
		return true;
	}

	private boolean check(char[][] board, int n) {
		return checkRow(board, n) && checkCol(board, n) && check3(board, n);
	}

}