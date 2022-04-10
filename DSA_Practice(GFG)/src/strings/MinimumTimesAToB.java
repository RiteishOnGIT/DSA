package strings;

public class MinimumTimesAToB {

	
	public static int numberOfTimes(String a, String b) {
		
		 int maxlen = (b.length()/a.length()) + 3;
	       String Str = a;
	       for (int i=1;i<=maxlen;i++){
	           if (Str.contains(b))
	           return i;
	           Str =Str + a;
	       }
	       return -1;
		
		
	}
	
	public static void main(String[] args) {
		
		
		
		String a = "qwq";
		String b = "qwqwqwqwqwqwqwqw";
		numberOfTimes(a, b);
		System.out.println(Integer.MIN_VALUE);
	}

}
