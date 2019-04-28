import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9507 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// number of test case
		int tc = Integer.parseInt(br.readLine());
		
		long dp[] = new long[70];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		
		for (int i = 4; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
		}
		
		for(int i = 0; i<tc; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		
		}
	}

}
