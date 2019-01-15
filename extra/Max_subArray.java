public class Max_subArray {
	
	public static void main(String[] args) {
		int[] array = { -2,3,5,-7,8,13,-20,14,1};
		int[] dp = new int[array.length+1];
		
		dp[0] = 0;
		
		for(int i = 1; i<dp.length; i++) {
			dp[i] = Math.max(dp[i-1] + array[i-1], array[i-1]);
		}
		
		int max = 0;
		for(int i = 0; i<dp.length; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}

}
