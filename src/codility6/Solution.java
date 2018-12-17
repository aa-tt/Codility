package codility6;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(975));
		System.out.println(solution(95));
		System.out.println(solution(1111));
		System.out.println(solution(4345344));
		System.out.println(solution(95));
		System.out.println(solution(95));
		System.out.println(solution(0));
		System.out.println(solution(99999999));
	}

	public static int solution(int N) {
		int max = ((((N == 0 ? 1 : N) + 99) / 100) * 100) + 1;
		return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(N + 1, max)).limit(max)
				.filter(i -> i % 10 == 0).toArray()[0];
	}

}
