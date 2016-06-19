import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] A = new int[n];
			
			for(int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}
			
			Arrays.sort(A);
			
			int[] S = new int[10000];
			
			
			for(int i = 1; i <= k; i++) {
				for(int j = 0; j < n; j++) {
					if(A[j] <= i) {
						S[i] = Math.max((S[i - A[j]] + A[j]), S[i]);
					}
					
				}
			}
			
			System.out.println(S[k]);
		}
	}
}
