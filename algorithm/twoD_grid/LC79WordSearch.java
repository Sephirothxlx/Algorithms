package algorithm.twoD_grid;

public class LC79WordSearch {
	public boolean bfs(char[][] board, int i, int j, String word, int[][] visit) {
		if (word.charAt(0) == board[i][j]) {
			if (word.length() == 1) {
				return true;
			}
			visit[i][j] = 1;
			if (i + 1 < board.length) {
				if (visit[i + 1][j] == 0) {
					if (bfs(board, i + 1, j, word.substring(1, word.length()), visit))
						return true;
					else
						visit[i + 1][j] = 0;
				}
			}
			if (i - 1 >= 0) {
				if (visit[i - 1][j] == 0) {
					if (bfs(board, i - 1, j, word.substring(1, word.length()), visit))
						return true;
					else
						visit[i - 1][j] = 0;
				}
			}
			if (j + 1 < board[i].length) {
				if (visit[i][j + 1] == 0) {
					if (bfs(board, i, j + 1, word.substring(1, word.length()), visit))
						return true;
					else
						visit[i][j + 1] = 0;
				}
			}
			if (j - 1 >= 0) {
				if (visit[i][j - 1] == 0) {
					if (bfs(board, i, j - 1, word.substring(1, word.length()), visit))
						return true;
					else
						visit[i][j - 1] = 0;
				}
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		if (board[0].length == 0)
			return false;
		if (word.length() == 0)
			return true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					int[][] visit = new int[board.length][board[0].length];
					if (bfs(board, i, j, word, visit) == true)
						return true;
				}
			}
		}
		return false;
	}
}
