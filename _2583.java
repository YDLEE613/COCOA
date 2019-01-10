package Solved;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2583 {
	static int[][] filled;
	static int[][] regionCnt;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int M, N;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String[] firstLine = scnr.nextLine().split(" ");

		M = Integer.parseInt(firstLine[0]); // Y
		N = Integer.parseInt(firstLine[1]); // X
		int K = Integer.parseInt(firstLine[2]);

		filled = new int[N + 1][M + 1];
		regionCnt = new int[N + 1][M + 1];

		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 0;

		for (int z = 0; z < K; z++) {
			String[] eachLine = scnr.nextLine().split(" ");
			fromX = Integer.parseInt(eachLine[0]);
			fromY = Integer.parseInt(eachLine[1]);
			toX = Integer.parseInt(eachLine[2]);
			toY = Integer.parseInt(eachLine[3]);

			// fill dashed regions
			for (int i = fromX; i < toX; i++) {
				for (int j = fromY; j < toY; j++) {
					filled[i][j] = -1;
				}
			}
		}

		int region = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (filled[i][j] == 0) {
//					System.out.println("i and j: " + i + " and "+ j);
					bfs(i, j, ++region);
				}
			}
		}
//		////////////////////////// print
//		System.out.println("////////////filled[][]////////////");
//		for (int i = M - 1; i >= 0; i--) {
//			for (int j = 0; j < N; j++) {
//				System.out.printf("%3d", filled[j][i]);
//			}
//			System.out.println();
//		}
//		///////////////////////////////
//		System.out.println("///////////regionCnt[][]///////////");
//		for(int i = M-1; i>=0; i--) {
//			for(int j = 0; j<N; j++) {
//				System.out.printf("%3d", regionCnt[j][i]);
//			}
//			System.out.println();
//		}

		int[] ans = new int[25*25];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(regionCnt[i][j] != 0) {
					ans[regionCnt[i][j]] += 1;
				}
			}
		}
		
		int cnt = 0;
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0) {
				cnt++;
				sb.append(ans[i] + " ");
			}
		}
		
		System.out.println(cnt);
		System.out.print(sb.toString().trim());
		scnr.close();
	}

	public static void bfs(int x, int y, int region) {
		Queue<String> q = new LinkedList<>(); // <key, value> = <X, Y>
		String coordsStr = x + " " + y;
		q.add(coordsStr);
		regionCnt[x][y] = region;
		
		while (!q.isEmpty()) {
			String tmp = q.peek();
			x = Integer.parseInt(tmp.split(" ")[0]);
			y = Integer.parseInt(tmp.split(" ")[1]);
			q.poll();

			for (int i = 0; i < dx.length; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
					if (filled[newX][newY] == 0 && regionCnt[newX][newY] == 0) {
						q.add(newX + " " + newY);
						regionCnt[newX][newY] = region;
						filled[newX][newY] = 1;
//						System.out.println("<newX, newY> region: <" + newX + ", " + newY + ">, " + region);

					}
				}
			}
		}

	}
}
