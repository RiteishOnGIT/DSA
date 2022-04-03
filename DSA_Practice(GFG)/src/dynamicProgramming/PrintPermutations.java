package dynamicProgramming;

public class PrintPermutations {

	public static void printPermutations(int arr[],int x ,int visited[], String s) {
		if(s.length() == arr.length) {
			System.out.println(s);
		}
		if(x == 0 || x == arr.length)return;
		
		for(int i =0; i < arr.length; i++) {
			if(x  <= arr.length) {
				if(visited[x] != 1) {
					visited[x] = 1;
					printPermutations(arr, i+1, visited, s+arr[x-1]);
				}
				else {
					x++;
				}
			}
		}
		visited[x] = 0;
		
	}
	
	public static void main(String[] args) {
		
		int array[] = {1,2,3};
		int visited[] = new int[4];
		printPermutations(array, 2 ,visited, "");
	}

}
