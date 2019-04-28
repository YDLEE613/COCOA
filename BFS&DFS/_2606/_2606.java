import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2606 {
	static int cnum;
	static int n;

	static int[] visited;
	static List<ArrayList<Integer>> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnum = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());

		visited = new int[cnum+1];
		arr = new ArrayList<ArrayList<Integer>>(cnum + 1);

		for (int i = 0; i < cnum + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}
		for (int i = 1; i < n+1; i++) {
			String[] each = br.readLine().split(" ");
			int a = Integer.parseInt(each[0]);
			int b = Integer.parseInt(each[1]);
			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		visited[1] = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int tmp = q.poll();

			for (int each : arr.get(tmp)) {
				if (visited[each] == 0) {
					q.add(each);
					visited[each] = 1;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
