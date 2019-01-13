package Solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		int[] base = new int[1000001];
		base[1] = 0;
		base[2] = 1;
		base[3] = 1;

		for (int i = 4; i < base.length; i++) {
			int num_3 = 1000000;
			int num_2 = 1000000;
			int num_1 = 1000000;
			if (i % 3 == 0) {
				num_3 = 1 + base[i / 3];
			}

			if (i % 2 == 0) {
				num_2 = 1 + base[i / 2];
			}

			num_1 = 1 + base[i - 1];

			int min = 0;
			min = Math.min(num_3, num_2);
			min = Math.min(min, num_1);
			
			base[i] = min;

		}
		System.out.println(base[num]);
	}

}