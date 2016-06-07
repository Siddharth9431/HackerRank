import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	
	public long coinChange(long[] c, long n, int m, long[][] memo) {
		
		if(n == 0) return 1;
		
		if(n < 0) return 0;
		
		if(m <= 0 && n >= 1) return 0;
		
		if(memo[(int)n][m] != -1) {
			return memo[(int)n][m];
		}
		else {
			memo[(int)n][m] = coinChange(c, n, m - 1, memo) + coinChange(c, n - c[m - 1], m, memo);
			return memo[(int)n][m];
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int m = sc.nextInt();
		
		long[] c = new long[m];
		
		for(int i = 0; i < m; i++) {
			c[i] = sc.nextLong();
		}
		
		CoinChange c1 = new CoinChange();
		
		long[][] memo1 = new long[(int)n + 1][m + 1];
		
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < m + 1; j++) {
				memo1[i][j] = -1;
			}
		}
		
		long ways = c1.coinChange(c, n, m, memo1);
		
		System.out.println(ways);
	}
}
