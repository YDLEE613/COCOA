import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _14502 {
	static int N;
	static int M;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] grid;
	static int[][] tempGrid;
	static int max = 0;
	static List<Dot> virusList = new ArrayList<Dot>();

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * First, read the input and store the location of virus.
	 * 
	 * */
	public static void main(String[] args) {
		/**
		 * Conditions: - N >= 3, M <=8 - number of virus: 2 <= Num <= 10 - num of walls
		 * needed: 3
		 */

		// Read size
		Scanner sc = new Scanner(System.in);
		String[] size = sc.nextLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);

		// Read the grid
		grid = new int[N][M];
		tempGrid = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempGrid[i][j] = grid[i][j] = Integer.parseInt(sc.next());

				if (grid[i][j] == 2) {
					virusList.add(new Dot(i, j));
				}
			}
		}
		buildWall(0, 0);
		System.out.println(max);
	}

	public static void buildWall(int start, int depth) {
		// All 3 walls are built
		if (depth == 3) {
			// store original grid
			copyGrid();

			// spread virus
			for (Dot dot : virusList) {
				spreadVirus(dot.x, dot.y);
			}

			max = Math.max(max, safeArea());
			return;
		}

		for (int i = start; i < N * M; i++) {
			int newX = i / M;
			int newY = i % M;

			if (grid[newX][newY] == 0) {
				grid[newX][newY] = 1;
				buildWall(i + 1, depth + 1);
				grid[newX][newY] = 0;
			}
		}
	}

	// calculate safe area
	public static int safeArea() {
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempGrid[i][j] == 0) {
					safe++;
				}
			}
		}
		return safe;
	}

	// spread virus
	static void spreadVirus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (tempGrid[nx][ny] == 0) {
					tempGrid[nx][ny] = 2;
					spreadVirus(nx, ny);
				}
			}
		}
	}

	// copy grid
	public static void copyGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				tempGrid[i][j] = grid[i][j];
			}
		}
	}

	// function to print grid
	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	// function to print number of 0,1,2s
	public static void printNums(int empty, int wall, int virus) {
		System.out.println("Empty: " + empty + "\nWall: " + wall + "\nVirus: " + virus);
	}
}
