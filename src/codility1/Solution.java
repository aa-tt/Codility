package codility1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("We test coders. Give us a try?"));
		System.out.println(solution("Forget  CVs !!!Save time . x x"));
		System.out.println(solution(".. b c. .a"));
	}

	public static int solution(String S) {

		Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)",
				Pattern.MULTILINE | Pattern.COMMENTS);

		Matcher reMatcher = re.matcher(S);
		List<String> sentences = new ArrayList<>();
		while (reMatcher.find()) {
			sentences.add(reMatcher.group());
		}
		List<String> validSentences = new ArrayList<>();
		int maxWordCount = 0;
		for (int i = 0; i < sentences.size(); i++) {
			String[] tempSentences = sentences.get(i).split("[.?!]");
			for (int j = 0; j < tempSentences.length; j++) {
				validSentences.add(tempSentences[j]);
			}
		}
		for (int i = 0; i < validSentences.size(); i++) {
			String[] words = validSentences.get(i).split("[ ]");
			List<String> validWords = new ArrayList<>();
			for (int j = 0; j < words.length; j++) {
				if (words[j].length() > 0)
					validWords.add(words[j]);
			}
			if (maxWordCount < validWords.size())
				maxWordCount = validWords.size();
		}

		return maxWordCount;
	}

}
