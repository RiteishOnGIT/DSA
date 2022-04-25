package recursion;

public class MobileNumeriKeypadSequence {

	public static void main(String[] args) {
		
		String s = "RITESHJANGID";
		String result = "";
		for(int i=0; i<s.length(); i++) {
			int value = 0;
			int difference = 0;
			int orgChar = s.charAt(i)-'A';
			if(orgChar >=0 && orgChar<=2) {
				value = 2;
				difference = orgChar - 0;
			}
			else if(orgChar>=3 && orgChar <=5) {
				value = 3;
				difference = orgChar - 3;
			}
			else if(orgChar>=6 && orgChar <=8) {
				value = 4;
				difference = orgChar - 6;
			}
			else if(orgChar>=9 && orgChar <=11) {
				value = 5;
				difference = orgChar - 9;
			}
			else if(orgChar>=12 && orgChar <=14) {
				value = 6;
				difference = orgChar - 12;
			}
			else if(orgChar>=15 && orgChar <=18) {
				value = 7;
				difference = orgChar - 15;
			}
			else if(orgChar>=19 && orgChar <=21) {
				value = 8;
				difference = orgChar - 19;
			}
			else if(orgChar>=22 && orgChar <=25) {
				value = 9;
				difference = orgChar - 22;
			}
			
			
			while((difference+1) != 0) {
				result += value;
				difference--;
			}
			
		}
		System.out.println(result);

	}

}
