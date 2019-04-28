package Solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Sieve of Eratosthenes
 * 
 */
public class _1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int upperBound = Integer.parseInt(input[1]);

		boolean[] marked = new boolean[upperBound + 1];

		int upperBoundSqrt = (int) Math.sqrt(upperBound);

		for (int i = 2; i <= upperBoundSqrt; i++) {
			if (!marked[i]) {
				if (i >= M) {
					sb.append(i + "\n");
				}
				for (int j = i * i; j < upperBound + 1; j += i) {
					marked[j] = true;
				}
			}
		}
		for (int i = upperBoundSqrt+1; i < upperBound + 1; i++) {
			if (!marked[i] && i > 1 && i >= M) {
				sb.append(i + "\n");
			}
		}
		bw.write(sb.toString().trim());
		bw.flush();
	}
}
