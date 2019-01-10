package Solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int K = Integer.parseInt(input[0]); // 4
		int N = Integer.parseInt(input[1]); // 11

		int[] numbers = new int[K];
		long mid = 0;
		long right = 0;
		long sum = 0;

		// get each number and max
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] =  Integer.parseInt(br.readLine());
			sum += numbers[i];
		}

		long left = 1;
		long result = 1;
		right = sum/N;

		while (left <= right) {
			mid = (left + right) / 2;
			
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += numbers[i] / mid;
			}
			if(count >= N) {
				left = mid+1;
				result = Math.max(result, mid);
			}else {
				right = mid -1;
			}
		}
		/*
		 * 	1 4, 5
		 * 	4 11, 802, 743, 457, 539
		 * 	1 1 1
		 * 	2 2, 1, 5
		 * */
		bw.write("" + result);
		bw.flush();
	}
}
