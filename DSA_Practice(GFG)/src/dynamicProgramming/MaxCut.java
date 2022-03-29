package dynamicProgramming;

public class MaxCut {
	
	
	static int maxCutInARod(int n, int a,int b, int c) {

		if(n < 0)return 0;
		if(n== 0)return 1;
		
		
		return 1+ Math.max(Math.max(maxCutInARod(n-a, a, b, c), maxCutInARod(n-b, a, b, c)),
				maxCutInARod(n-c, a, b, c));
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxCutInARod(5, 1, 2, 3));
	}

}
