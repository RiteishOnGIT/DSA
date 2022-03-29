package stack;

import java.util.ArrayDeque;

public class MinimumAddToMakeParenthesis {

	public static Integer makeParenthesisValid(String s) {

		ArrayDeque<Character> ad = new ArrayDeque<Character>();

		if (s.length() == 0)
			return 0;

		int i = 0, counter = 0;

		while (i < s.length()) {
			if (s.charAt(i) == ')')
				counter++;
			else {
				ad.add(s.charAt(i));
				i++;
				break;
			}
			i++;
		}

		while (!ad.isEmpty() || i < s.length()) {
			if (i < s.length()) {
				if (s.charAt(i) == '(') {
					ad.add('(');
				}
				else {
					if (s.charAt(i) == ')') {
						if (ad.size() != 0) {
							if (ad.getLast() == '(') {
								ad.pollLast();
							} else {
								counter++;
							}
						} else {
							counter++;
						}

					}
				}
				i++;
			} else {
				break;
			}
		}

		return counter + ad.size() + s.length() - i;

	}

	public static void main(String[] args) {

		System.out
				.println(makeParenthesisValid("(((()()()(((())))()()()()()()()()((((((()))))))))))))))))))))))))))()"));
	}

}
