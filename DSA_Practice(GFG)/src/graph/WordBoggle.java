package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBoggle {
	
	public static boolean isPresent(char board[][], String word, int i, int j, int visited[][], int k) {
		if(k == word.length())return true;
		if(i < 0 || i>=board.length || j < 0 || j >= board[0].length)return false;
		if(word.charAt(k) != board[i][j]) {
			return false;
		}

		if(visited[i][j] != -1)return false;
		visited[i][j] = 1;

		k++;
		boolean var1 = isPresent(board, word, i-1, j, visited, k);

		boolean var2 = isPresent(board, word, i+1, j, visited, k);

		boolean var3 = isPresent(board, word, i, j-1, visited, k);

		boolean var4 = isPresent(board, word, i, j+1, visited, k);

		boolean var5 = isPresent(board, word, i-1, j-1, visited, k);

		boolean var6 = isPresent(board, word, i-1, j+1, visited, k);

		boolean var7 = isPresent(board, word, i+1, j-1, visited, k);

		boolean var8 = isPresent(board, word, i+1, j+1, visited, k);
		
		visited[i][j] = -1;
		return var1||var2||var3||var4||var5||var6||var7||var8;
		
	}
	
	
	
	public static String[] wordBoggle(char board[][], String[] dictionary)
    {
        int visited[][] = new int[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				visited[i][j] = -1;
			}
		}
		
		ArrayList<String>result = new ArrayList<String>();
		boolean flag = true;
		for(int i=0; i<dictionary.length; i++) {
			flag = true;
			for(int j=0; j<board.length; j++) {
				for(int k=0; k<board[0].length; k++) {
		 			if(isPresent(board, dictionary[i], j, k, visited, 0)) {
						result.add(dictionary[i]);
						flag = false;
						break;
					}else {
						for(int p=0; p<board.length; p++) {
							for(int q=0; q<board[0].length; q++) {
								visited[p][q] = -1;
							}
						}
					}
				}
				if(!flag)break;
			}
			
		}
		System.out.println(result);
		String [] res = new String[result.size()];
		int a = 0;
		for(String s: result) {
			res[a++] = s;
		}
		return res;
    }
	
	
	public static void main(String[] args) {
		char [][]board = {{'G', 'I', 'Z', 'U', 'E', 'K', 'Q', 'S', 'E'}};
		String []dictionary = {"GEEKS", "FOR", "QUIZ", "IZUEK", "ESQ"};
		wordBoggle(board, dictionary);
	}

}
