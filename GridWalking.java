import java.util.Arrays;
import java.util.Scanner;

public class GridWalking {
	
	public void gridWalk() {
		
		Scanner sc = new Scanner(System.in);
		
		int prime = 1000000007;
		
		int T = sc.nextInt();
		
		
		for(int v = 0; v < T; v++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] X = new int[N];
			int[] D = new int[N];					
			
			for(int j = 0; j < N; j++) {
				X[j] = sc.nextInt();
			}
			
			for(int j = 0; j < N; j++) {
				D[j] = sc.nextInt();
			}
		
			long[][] arr1 = new long[N][M + 1];
			
			for(int i = 0; i < N; i++) {
				int n = D[i];
				if(n == 1) {
					Arrays.fill(arr1[i], 0);
					arr1[i][0] = 1;
					continue;
				}
				long[][] arr2 = new long[M + 1][n];  //Temporary array  
				
				Arrays.fill(arr2[0], 1);
				
				for(int k = 1; k <= M; k++) {
					arr2[k][0] = arr2[k - 1][1];			//Base Cases
					arr2[k][n - 1] = arr2[k - 1][n - 2];
					
					for(int g = 1; g < n - 1; g++) {
						arr2[k][g] = (arr2[k - 1][g - 1] + arr2[k - 1][g + 1]) % prime;
					}
				}
				for(int k = 0; k <= M; k++) {
					arr1[i][k] = arr2[k][X[i] - 1];
				}
				
			}
			
			long[][] CnK = new long[M + 1][M + 1];
			
			CnK[0][0] = 1;
			
			for(int i  = 1; i <= M; i++) {
				CnK[i][0] = 1;
				for(int j = 1; j <= i; j++) {
					CnK[i][j] = (CnK[i - 1][j - 1] + CnK[i - 1][j]) % prime;
				}
			}
			
			long[][] ans = new long[N][M + 1];
			
			for(int i = 0; i <= M; i++) {
				ans[0][i] = arr1[0][i];
			}
			for(int i = 1; i < N; i++) {
				for(int j = 0; j <= M; j++) {
					long temp = 0;
					for(int k = 0; k <= j; k++) {
						long v1 = arr1[i][k] % prime;
						long v2 = (v1 * ans[i - 1][j - k]) % prime;
						long v3 = (v2 * CnK[j][k]) % prime;
						temp = temp + v3;
						temp = temp % prime;
					}
					ans[i][j] = temp;
				}
			}
			
			System.out.println(ans[N-1][M]);
	}
	
}	
	public static void main(String[] args) {
		
		GridWalking g = new GridWalking();
		
		g.gridWalk();
		
				
	}
	
}
