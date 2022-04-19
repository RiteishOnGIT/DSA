package strings;

public class StringPermutations {
	
	public static void main(String[] args) {
		
		String s = "ABCD";
		String extra = "";
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			String temp = "";
			count =0;
			temp +=s.charAt(i);
			int j = i;
			extra = temp;
			while(count != s.length()-1) {
				temp = extra;
				j = (j+1)%(s.length());
				temp += s.charAt(j);
				int k =(j+1)%(s.length());
				int kCount = 0;
				count++;
				while(kCount < s.length()-2) {
					if(s.charAt(i) == s.charAt(k)) {

						k =(k+1)%(s.length());
						continue;
					}
					temp += s.charAt(k);
					k =(k+1)%(s.length());
					kCount++;
				}
				System.out.println(temp);
			}
		}
		
		
	}
	
	
}
