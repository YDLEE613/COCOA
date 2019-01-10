package Solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2900 {

	public static void main(String[] args) throws IOException {
		int n;
		long[] tot;
		int[] x, a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		tot = new long[n];
		x = new int[n];
		a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			int jump = Integer.parseInt(st.nextToken());
			x[jump] += 1; // jump가 불린 횟수만큼 x에 저장
		}
		
		a[0] = k;
		tot[0] = k;
		for(int i = 1; i < n; i++) {
			if(x[i] != 0) { //x[i] 가 0이 아니라면 한번이라도 jump 인수로 받은 것
				for(int j = 0; j < n; j+=i) {
					if(j != 0) a[j] = a[j] + x[i];
				}
			}
		}
		
        // a에 있는 합을 미리 저장
		for(int i = 1; i < n; i++) {
			tot[i] = tot[i - 1] + a[i];
		}
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long total = 0; 
			if(begin == 0) {
				total = tot[end];
			}else {
				total = tot[end] - tot[begin - 1];
			}
			bw.write(""+ total + "\n");
		}
		
		bw.close();
	}
}
