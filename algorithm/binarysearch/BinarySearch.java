package algorithm.binarysearch;

public class BinarySearch {
	public static int binarySearch(int[] A, int low, int high, int c) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		if (A[mid] == c)
			return mid;
		else if (A[mid] > c)
			return binarySearch(A, 0, mid - 1, c);
		else
			return binarySearch(A, mid + 1, high, c);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(a, 0, a.length, 0));
	}
}
