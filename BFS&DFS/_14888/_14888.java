import java.util.Scanner;

public class _14888 {
	static int[] nums;
	static int[] ops;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[11];
		ops = new int[10];
		visited = new boolean[11];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		int index = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt();

			for (int j = 0; j < cnt; j++) {
				ops[index++] = i + 1;
			}
		}

//		print(nums);
//		print(ops);
		
		dfs(0,1, nums[0], 0);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int v, int index, int num, int len) {
		int result = 0;
		if (len == N - 1) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		} else {
			
			for (int i = 0; i < N - 1; i++) {
				
				if (!visited[i]) {
					switch (ops[i]) {
					case 1:
						result = num + nums[index];
						break;
					case 2:
						result = num - nums[index];
						break;
					case 3:
						result = num * nums[index];
						break;
					case 4:
						result = num / nums[index];
						break;
					}
					
					visited[i] = true;
					dfs(i, index+1, result, len+1);
				}
			}
		}
		visited[v] = false;
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
