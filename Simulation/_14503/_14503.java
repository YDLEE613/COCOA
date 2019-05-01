import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _14503 {

	static int n; // 3<= N,M <= 50
	static int m;
	static int r;
	static int c;
	static int d;

	static Robot robo;
	static int[][] map;
	static boolean[][] cleaned;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static Queue<Robot> q = new LinkedList<>();

	static class Robot {
		int x, y;
		int dir;

		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		map = new int[n][m];
		cleaned = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		clean();

		int count = 0;
		
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[i].length; j++) {
				if(map[i][j]==2) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	

	static int turnLeft(int dir) {
		int nd = 0;
		if (dir == 0) {
			nd = 3;
		} else if (dir == 1) {
			nd = 0;
		} else if (dir == 2) {
			nd = 1;
		} else if (dir == 3) {
			nd = 2;
		}
		return nd;
	}

	static int turnBack(int dir) {
		int nd = 0;
		if (dir == 0) {
			nd = 2;
		} else if (dir == 1) {
			nd = 3;
		} else if (dir == 2) {
			nd = 0;
		} else if (dir == 3) {
			nd = 1;
		}
		return nd;
	}

	static void clean() {
		q.add(new Robot(r, c, d));

		while (!q.isEmpty()) {
			Robot curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			int dir = curr.dir;

			// 현재 위치 청소하고.
			cleaned[x][y] = true;
			map[x][y] = 2;

			boolean flag = false;

			for (int i = 0; i < 4; i++) {
				int nd = turnLeft(dir); // rotate left
				int nx = x + dx[nd];
				int ny = y + dy[nd];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) // out of range
					continue;
				if (map[nx][ny] != 1 && cleaned[nx][ny] == false) { // not cleaned && not a wall
					cleaned[nx][ny] = true; // clean
					map[nx][ny] = 2;
					q.add(new Robot(nx, ny, nd)); // add the curr loc to queue
					flag = true;
					break;
				} else {// wall or cleaned, change dir.
					dir = nd;
				}
			}
			
			// no where to clean
			if (flag == false) {
				int nx = x + dx[turnBack(dir)];
				int ny = y + dy[turnBack(dir)];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1) // out of range
					continue;
				map[nx][ny] = 2;
				cleaned[nx][ny] = true;
				q.add(new Robot(nx, ny, dir)); // don't change dir.
			}

		}
	}

	static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
