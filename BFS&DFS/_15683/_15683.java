import java.util.ArrayList;
import java.util.Scanner;

public class _15683 {
	static int n;
	static int m;

	static int[][] room;
	static int[] rot_cam = { 4, 2, 4, 4, 1 };
	static ArrayList<CCTV> cctv = new ArrayList<CCTV>();

	static int ret = 100;

	static public class CCTV {
		int type, x, y;

		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		room = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				room[i][j] = sc.nextInt();
				if (room[i][j] != 0 && room[i][j] != 6) {
					cctv.add(new CCTV(room[i][j] - 1, i, j));
				}
			}
		}

		dfs(0);
		System.out.println(ret);

	}

	static void copy(int[][] desc, int[][] src) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				desc[i][j] = src[i][j];
			}
		}
	}

	static void update(int dir, CCTV cctv) {
		dir = dir % 4;

		if (dir == 0) {// east
			for (int i = cctv.y + 1; i < m; i++) {
				if (room[cctv.x][i] == 6) {
					break;
				}
				room[cctv.x][i] = -1;
			}
		} else if (dir == 1) {// north
			for (int i = cctv.x - 1; i >= 0; i--) {
				if (room[i][cctv.y] == 6) {
					break;
				}
				room[i][cctv.y] = -1;
			}
		} else if (dir == 2) {// west
			for (int i = cctv.y - 1; i >= 0; i--) {
				if (room[cctv.x][i] == 6) {
					break;
				}
				room[cctv.x][i] = -1;
			}
		} else if (dir == 3) {// north
			for (int i = cctv.x + 1; i < n; i++) {
				if (room[i][cctv.y] == 6) {
					break;
				}
				room[i][cctv.y] = -1;
			}
		}
	}

	static void dfs(int cctv_index) {
		if (cctv_index == cctv.size()) {
			// condition to stop
			//print(room);
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (room[i][j] == 0) {
						count++;
					}
				}
			}

			if (ret > count) {
				ret = count;
			}
			return;
		}

		int[][] backup = new int[n][m];

		int type = cctv.get(cctv_index).type;

		for (int dir = 0; dir < rot_cam[type]; dir++) {
			// map backup
			copy(backup, room);

			// map update
			if (type == 0) {
				update(dir, cctv.get(cctv_index));
			} else if (type == 1) {
				update(dir, cctv.get(cctv_index));
				update(dir + 2, cctv.get(cctv_index));
			} else if (type == 2) {
				update(dir, cctv.get(cctv_index));
				update(dir + 1, cctv.get(cctv_index));
			} else if (type == 3) {
				update(dir, cctv.get(cctv_index));
				update(dir + 1, cctv.get(cctv_index));
				update(dir + 2, cctv.get(cctv_index));
			} else if (type == 4) {
				update(dir + 1, cctv.get(cctv_index));
				update(dir + 2, cctv.get(cctv_index));
				update(dir + 3, cctv.get(cctv_index));
				update(dir + 4, cctv.get(cctv_index));
			}

			dfs(cctv_index + 1);
			// map backup
			copy(room, backup);

		}
	}

	static void print(int[][] arr) {
		System.out.println("---------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
