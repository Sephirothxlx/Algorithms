package algorithm.binarysearch;

public class LCSearcha2DMatrixII {
	public boolean find(int[][] matrix, int target, int i, int j) {
		if (matrix[i][j] == target)
			return true;
		else if (matrix[i][j] < target) {
			return find(matrix, target, i, j - 1);
		} else {
			return find(matrix, target, i - 1, j);
		}
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		return find(matrix, target, 0, matrix[0].length - 1);
	}
}
