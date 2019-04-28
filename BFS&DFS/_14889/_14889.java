import java.io.*;
import java.util.*;

// 능력치 사이의 최솟값을 구해라
public class _14889 {
	static int n, ret;
	static int[][] table;
	static int[] team1, team2;
	static int[] pick;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		table = new int[n][n];
		team1 = new int[n / 2];
		team2 = new int[n / 2];
		pick = new int[n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = sc.nextInt();
			}
		}

		ret = Integer.MAX_VALUE;

		dfs(0, 0);
		System.out.println(ret);
	}

	static void dfs(int curr, int pick_count) {
		if (pick_count == n / 2) {
			// 뭔가 처리해야함
			// 팀 능력치 계산하고 최솟값을 찾아야하겟지?
			update();

			return;
		} else {
			for (int i = curr; i < n; i++) {
				pick[i] = 1;
				dfs(i + 1, pick_count + 1);
				pick[i] = 0;
			}
		}
	}

	static void update() {
		int team1_size = 0, team2_size = 0;
		for (int i = 0; i < n; i++) {
			if (pick[i] == 0) {
				team1[team1_size] = i;
				team1_size++;
			} else {
				team2[team2_size] = i;
				team2_size++;
			}
		}
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i+1; j < n / 2; j++) {
					sum1 += (table[team1[i]][team1[j]] +table[team1[j]][team1[i]]);
					sum2 += (table[team2[i]][team2[j]] +table[team2[j]][team2[i]]);
			}
		}
		
		if(ret > Math.abs(sum1-sum2)) {
			ret = Math.abs(sum1 - sum2);
		}
	}
}
