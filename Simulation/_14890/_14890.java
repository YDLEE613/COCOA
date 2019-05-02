import java.util.Scanner;

public class _14890 {
	static int[][] rowMap;
	static int[][] colMap;
	static int n;
	static int l;

	static int rowCount = 0;
	static int colCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		l = sc.nextInt();

		rowMap = new int[2 * n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rowMap[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rowMap[n + i][j] = rowMap[j][i];
			}
		}
		//print(rowMap);

		int count = 0;
		int i, j;
		int ret = 0;

		for (i = 0; i < 2 * n; i++) {
			count = 1;
			for (j = 0; j < n - 1; j++) {
				if (rowMap[i][j] == rowMap[i][j + 1]) { // flat
					count++;
				} else if (rowMap[i][j] + 1 == rowMap[i][j + 1] && count >= l) {// uphill
					count = 1;
				} else if (rowMap[i][j] - 1 == rowMap[i][j + 1] && count >= 0) {
					count = 1-l;
				}else {
					//System.out.println("break at " + i);
					break;
				}
			}
			
			if(j == n-1 && count>=0) {
				//System.out.println("i: " + i);
				ret++;
			}
		}
		System.out.println(ret);

	}

	static void print(int[][] arr) {
		System.out.println("---------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
