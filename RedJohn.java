import java.util.Arrays;
import java.util.Scanner;

public class RedJohn {
	
public int Sieve(int n) {
		
		boolean[] prime = new boolean[n + 1];
		
		Arrays.fill(prime, true);
		
		for(int p = 2; p <= Math.sqrt(n); p++) {
			
			if(prime[p] == true) {
				
				for(int i = 2 * p; i <= n; i = i + p) {
					prime[i] = false;
				}
			}
		}
		
		int count = 0;
		
		for(int p = 2; p <= n; p++) {
			if(prime[p] == true) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			
			int[] memo = new int[N];
			
			if(N == 1) memo[0] = 1;
			
			if(N > 1 && N <= 2) memo[0] = memo[1] = 1;
			
			if(N > 2 && N <= 3) memo[0] = memo[1] = memo[2] = 1;
			
			if(N == 4) memo[3] = 2;
			
			if(N > 3) {
				memo[3] = 2;
				memo[0] = memo[1] = memo[2] = 1;
				for(int k = 4; k < N; k++) {
					
					memo[k] = memo[k - 1] + memo[k - 4];
				}
			}
			
			RedJohn r = new RedJohn();
			
			int prime = r.Sieve(memo[N - 1]);
			
			System.out.println(prime);
		}
	}
}
