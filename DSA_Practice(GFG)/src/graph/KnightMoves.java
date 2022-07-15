package graph;

import java.util.ArrayDeque;
import java.util.Arrays;

class Position {
	int x;
	int y;
	int distance;

	public Position(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

public class KnightMoves {

	public static boolean isValid(int i, int j, int n, int visited[][]) {
		if (i < 1 || i > n || j < 1 || j > n || (visited[i][j] == 1))
			return false;
		else
			return true;

	}

	public static int minimumMoves(int visited[][], int knightPos[], int targetPos[], int n) {

		ArrayDeque<Position> q = new ArrayDeque<Position>();
		q.addFirst(new Position(knightPos[0], knightPos[1], 0));
		visited[knightPos[0]][knightPos[1]] = 1;
		while (!q.isEmpty()) {
			Position curr = q.pollLast();
			int x = curr.x;
			int y = curr.y;
			if(x == targetPos[0] && y == targetPos[1])return curr.distance;
			int dist = curr.distance;
			if (isValid(x - 1, y + 2, n, visited)) {
				q.addFirst(new Position(x-1, y+2, dist+1));
				visited[x-1][y+2] = 1;
			}
			if (isValid(x - 1, y - 2, n, visited)) {
				q.addFirst(new Position(x-1, y-2, dist+1));
				visited[x-1][y-2] = 1;
			}
			if (isValid(x + 1, y + 2, n, visited)) {
				q.addFirst(new Position(x+1, y+2, dist+1));
				visited[x+1][y+2] = 1;
			}
			if (isValid(x + 1, y - 2, n, visited)) {
				q.addFirst(new Position(x+1, y-2, dist+1));
				visited[x+1][y-2] = 1;
			}
			if (isValid(x - 2, y + 1, n, visited)) {
				q.addFirst(new Position(x-2, y+1, dist+1));
				visited[x-2][y+1] = 1;
			}
			if (isValid(x - 2, y - 1, n, visited)) {
				q.addFirst(new Position(x-2, y-1, dist+1));
				visited[x-2][y-1] = 1;
			}
			if (isValid(x + 2, y + 1, n, visited)) {
				q.addFirst(new Position(x+2, y+1, dist+1));
				visited[x+2][y+1] = 1;
			}
			if (isValid(x + 2, y - 1, n, visited)) {
				q.addFirst(new Position(x+2, y-1, dist+1));
				visited[x+2][y-1] = 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int knightPos[] = { 30, 30 };
		int targetPos[] = { 1, 1 };

		int n = 30;
		int visited[][] = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited[i], 0);
		}
		
		System.out.println(minimumMoves(visited, knightPos, targetPos, n));

	}

}
