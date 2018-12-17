package HealthBiCodility;

public class LongestPrefixArray {

	public static void main(String[] args) {

		System.out.println(solution(6, 13, new int[] { 13, 13, 1, 6 }));
		System.out.println(solution(100, 63, new int[] { 100, 63, 1, 6, 2, 13 }));
		System.out.println(solution(-1, 1, new int[] { -1, 1000000002, 1, -1, 1 }));
		System.out.println(solution(100, 63, new int[] { 1 }));
		System.out.println(solution(100, 63, new int[] {}));
	}

	static int solution(int X, int Y, int[] A) {
		int N = A.length;
		int result = -1;

		int nX = 0;
		int nY = 0;
		for (int i = 0; (N > 0 && N < 100001) && i < N && (A[i] > 0 && A[i] < 1000000001); i++) {
			// for (int i = 0; i < N; i++) {
			if (A[i] == X)
				nX += 1;
			else if (A[i] == Y)
				nY += 1;
			if ((nX != 0 && nY != 0) && (nX == nY))
				result = i;
		}
		return result;
	}

}
