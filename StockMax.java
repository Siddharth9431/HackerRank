import java.util.Scanner;

public class StockMax {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			int[] s = new int[n];
			
			for(int j  = 0; j < n; j++) {
				s[j] = sc.nextInt();
			}
			
			int maxSum = Integer.MIN_VALUE;
			long profit = 0;
			
			for(int k = n-1; k >=0; k--) {
				if(s[k] > maxSum) {
					maxSum = s[k];
				}
				
				profit = profit + (maxSum - s[k]);
				
			}
			
			System.out.println(profit);
			
		}
		
	}
}
