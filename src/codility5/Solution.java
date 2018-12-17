package codility5;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class Solution {

	public static void main(String[] args) {
		find_min(solution(0));
	}

	public static int[] solution(int N) {
		int[] ints = {};
		if (N > 1) {
			IntStream positiveIntsStream = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, N)).limit(N);
			int[] positiveInts = positiveIntsStream.toArray();
			for (int i = 0; i < positiveInts.length; i++)
				System.out.print(positiveInts[i] + " ");
			ints = positiveInts;
		}
		if ((N == 1) || (N == 0) || (N < 0)) {
			int[] oneInts = { 1 };
			ints = oneInts;
		}
		return ints;
	}

	static int find_min(int[] A) {
		int ans = 0;
		// ans = A[0];
		for (int i = 1; i < A.length; i++) {
			if (ans > A[i]) {
				ans = A[i];
			}
		}
		System.out.println("ans-" + ans);
		return ans;
	}
}
