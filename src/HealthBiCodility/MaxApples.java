package HealthBiCodility;

public class MaxApples {

	public static void main(String[] args) {
		System.out.println("max " + solution(new int[] { 6, 1, 4, 6, 3, 2, 7, 4 }, 3, 2));
		System.out.println("max " + solution(new int[] { 10, 19, 15 }, 2, 2));
	}

	private static int solution(int[] A, int K, int L) {
		int N = A.length;
		if (K + L > N)
			return -1;

		int[] fromLeft = new int[N];
		int[] fromRight = new int[N];
		int max = 0;

		for (int i = 2; i < N - L + 1; i++) {
			fromLeft[i] = Math.max(0, fromLeft[i - 1] + A[i - 1]);
		}
		for (int k = 0; k < fromLeft.length; k++)
			System.out.print(fromLeft[k] + "->");
		System.out.println();

		for (int i = N - 3; i >= K; i--) {
			fromRight[i] = Math.max(0, fromRight[i + 1] + A[i + 1]);
		}
		for (int k = 0; k < fromRight.length; k++)
			System.out.print(fromRight[k] + "->");
		System.out.println();

		for (int i = 1; i < N - 1; i++) {
			max = Math.max(max, fromLeft[i] + fromRight[i]);
		}

		return max;
	}

}
