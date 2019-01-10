package Solved;
import java.util.Scanner;

public class _1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] squared = new int[100001];
		
		for(int i = 1; i<317; i++) {
			squared[i*i] = 1;
		}
		
		squared[0] = 0;
		squared[1] = 1;
		squared[2] = 2;
		
		for(int i = 3; i<100001; i++) {
			int sqrt = (int)Math.sqrt(i); // i=4, sqrt = 2
			int min = Integer.MAX_VALUE;
			
			for(int j = sqrt; j>=1; j--) { // 2,1
				int tmp = 1+squared[i-(j*j)]; 
				if(min > tmp) {
					min = tmp;
					squared[i] = min;
				}
			}
		}
		System.out.println(squared[num]);
	}
}
