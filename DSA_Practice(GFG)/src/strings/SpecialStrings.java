package strings;

public class SpecialStrings {
	
	public static Integer combinations = 0;
	
	public static int isPossible(String s, int i, int k) {


		if (k < s.length()) {
			if (s.charAt(i) == s.charAt(k)) {
				k = i;
				while (k < s.length() && s.charAt(i) == s.charAt(k)) {
					k++;
					combinations++;
				}
				i = k;
			}
		}
		if(combinations == 0)return -1;
		return k;

	}

	public static Long countSpecialStrings(String s) {

		Long count =0l;
		int i = 0;
		int j = i - 1;
		int k = i + 1;
		while (i < s.length()) {
			
			{
				while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
					j--;
					k++;
					count++;
				}
			}

			if(isPossible(s, i, k) != -1) {
				i = k;
			}
			

			count += ((combinations - 1) * combinations) / 2;
			combinations = 0;
			i++;
			j = i - 1;
			k = i + 1;
		}
		return count;

	}

	public static void main(String[] args) {
		String s = "abbaeae";
		System.out.println(countSpecialStrings(s));

	}

}
