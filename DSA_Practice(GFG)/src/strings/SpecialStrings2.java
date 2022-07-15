package strings;

class Pair {
	Integer count;
	Character c;

	public Pair(Integer count, Character c) {
		this.count = count;
		this.c = c;
	}

	@Override
	public String toString() {
		return count + " " + c;
	}
}

public class SpecialStrings2 {

	public static Long countSpecialStrings(String s) {
		if (s.length() == 1)
			return 1l;

		Pair left[] = new Pair[s.length()];
		Pair right[] = new Pair[s.length()];
		left[0] = new Pair(1, s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (left[i - 1].c == s.charAt(i)) {
				int counter = left[i - 1].count;
				while (i < s.length() && left[i - 1].c == s.charAt(i)) {
					counter++;
					left[i] = new Pair(counter, left[i - 1].c);
					i++;
				}

			}
			if (i < s.length())
				left[i] = new Pair(1, s.charAt(i));

		}
		right[s.length() - 1] = new Pair(1, s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if (right[i + 1].c == s.charAt(i)) {
				int counter = right[i + 1].count;
				while (i >= 0 && right[i + 1].c == s.charAt(i)) {
					counter++;
					right[i] = new Pair(counter, right[i + 1].c);
					i--;
				}

			}
			if (i >= 0)
				right[i] = new Pair(1, s.charAt(i));

		}

		Long count = (long) s.length();
		Integer combinations = 0;
		int i = 0;
		if (s.charAt(i) == right[i + 1].c) {
			combinations = 1 + right[i + 1].count;
			i = 1 + right[i + 1].count;
		} else {
			i = 1;
		}
		count += ((combinations - 1) * combinations) / 2;
		for (; i < s.length() - 1; i++) {
			combinations = 0;
			if (left[i - 1].c == right[i + 1].c) {
				count += Math.min(left[i - 1].count, right[i + 1].count);
			} else if (s.charAt(i) == right[i + 1].c) {
				combinations = 1 + right[i + 1].count;
				i += right[i + 1].count;
			}
			count += ((combinations - 1) * combinations) / 2;

		}

		return count;
	}

	public static void aa(String sentence) {

		int str = 0;
		int integer = 0;
		sentence = "can you give me 10 bucks puf                 in 7.5 or 7";
		int lon = 0;
		String[] s = sentence.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (s[i] == "")
				continue;
			String input = s[i];
			String dataType = null;

			if (input.matches("\\d+")) {
				dataType = "integer";
				integer++;
			}

			else if (input.matches("\\d*[.]\\d*")) {
				dataType = "double";
				lon++;
			}

			else if (input.matches("[^ ]*")) {
				dataType = "string";
				str++;
			}
		}
		System.out.println("string " + str);
		System.out.println("integer " + integer);
		System.out.println("double " + lon);

	}

	public static void main(String[] args) {
		short i = 010;
		short j = 017;
		aa(null);
		
		Float d1 = 3.0f;
		Integer aInteger = d1.intValue();
		Byte B = d1.byteValue();
		Double aDouble = d1.doubleValue();
		System.out.println(aInteger+B+aDouble);
		
	}

}
