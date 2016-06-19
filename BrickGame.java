import java.util.Scanner;

public class BrickGame {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			int[] A = new int[N];
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			long sum = 0;
			
			long[] DP = new long[N + 5];
			
			DP[N] = DP[N + 1] = DP[N + 2] = 0;
			
			for(int i = N - 1; i >= 0; i--) {
				sum = sum + A[i];
				
				DP[i] = sum - Math.min(Math.min(DP[i + 1], DP[i + 2]), DP[i + 3]);
				
			}
			
			System.out.println(DP[0]);
		}
	}
}
