package codility2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

	public static void main(String[] args) {
		System.out.println(solution(4, "1A 2B 3E 4D 1C"));
		System.out.println(solution(2, "1A 1B 1C 1E 1D 1F 1G"));
		System.out.println(solution(2, "1A 1B 1C 1E 1D 1F 1G 1H 1J 1K"));
		System.out.println(solution(5, "1A 2A 3A 4A 5A 3B 2C 4C 1D 5D"));
		System.out.println(solution(5, "1A 2A 3A 4A 5A 1K 2K 3K 4K 5K 1B 1C 1D 1E 1F 1G 1H 1J 5B 5C 5D 5E 5F 5G 5H 5J"));
		System.out.println(solution(6, "1A 2A 3A 4A 5A 1K 2K 3K 4K 5K 1B 1C 1D 1E 1F 1G 1H 1J 5B 5C 5D 5E 5F 5G 5H 5J"));
		System.out.println(solution(5, "1A 1K 5A 5K"));
		System.out.println(solution(5, "1A 1E 1K 5A 5E 5K"));
	}

	public static int solution(int N, String S) {
		int groupSize = 3; // family of size 3
		List<String> reservedSeats = Stream.of(S.split(" ")).sorted().collect(Collectors.toList()); // get reserved seats
		int numOfGroupsPossible = (((N * 3) / groupSize) * 3); // assume reserved seats are sorted and together
		for (Integer rowNum = 1; rowNum <= N; rowNum++) {
			// filter for the seat group A B C
			if (Stream
					.of(rowNum.toString().concat("A"), rowNum.toString().concat("B"), rowNum.toString().concat("C")).filter((seat) -> {
				if (reservedSeats.stream().filter(rs -> rs.equals(seat)).collect(Collectors.toList()).size() > 0)
					return true;
				return false;
			}).collect(Collectors.toList()).size() > 0)
				numOfGroupsPossible--;
			// filter for the seat group H J K
			if (Stream
					.of(rowNum.toString().concat("H"), rowNum.toString().concat("J"), rowNum.toString().concat("K")).filter((seat) -> {
				if (reservedSeats.stream().filter(rs -> rs.equals(seat)).collect(Collectors.toList()).size() > 0)
					return true;
				return false;
			}).collect(Collectors.toList()).size() > 0)
				numOfGroupsPossible--;
			// filter for the seat group D E F G
			String d = rowNum.toString().concat("D");
			String g = rowNum.toString().concat("G");
			if (Stream.of(rowNum.toString().concat("E"), rowNum.toString().concat("F")).filter((seat) -> {
				if (reservedSeats.stream().filter(rs -> rs.equals(seat)).collect(Collectors.toList()).size() > 0)
					return true;
				return false;
			}).collect(Collectors.toList()).size() > 0)
				numOfGroupsPossible--;
			else {
				if ((reservedSeats.stream().filter(rs -> rs.equals(d)).collect(Collectors.toList()).size() > 0)
						&& (reservedSeats.stream().filter(rs -> rs.equals(g)).collect(Collectors.toList()).size() > 0))
					numOfGroupsPossible--;
			}
		}
		return numOfGroupsPossible;
	}
}
