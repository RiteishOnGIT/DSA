package arrays;

public class FindTheWord {

	public static Boolean DFS(char [][] board, int n, int m, int j, String word, boolean visited[][]) {
		if(j == word.length())return true;
		if(n < 0 || n > board.length-1 || m<0 || m > board[0].length-1)return false;
		if(board[n][m] != word.charAt(j))return false;
		if(visited[n][m] == true)return false;
		
		visited[n][m] = true;
		boolean topWord = DFS(board, n-1, m, j+1, word, visited);
		if(topWord)return true;
		boolean bottomWord = DFS(board, n+1, m, j+1, word, visited);
		if(bottomWord)return true;
		boolean leftWord = DFS(board, n, m-1, j+1, word, visited);
		if(leftWord)return true;
		boolean rightWord = DFS(board, n, m+1, j+1, word, visited);
		if(rightWord)return true;
		visited[n][m] = false;
		return topWord||bottomWord||leftWord||rightWord;
		
		
		
		
	}
	
	public static Boolean findTheWordIsPresent(char[][] board, String word) {
		
		boolean [][] visited = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(DFS(board, i, j, 0, word, visited))return true;
			
			}
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
		
		char board [][]= {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		
		String wordString = "ABCCSE";
		
		System.out.println(findTheWordIsPresent(board, wordString));
	}
	
	
}
