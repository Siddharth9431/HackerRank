import java.awt.List;
import java.util.Scanner;
import java.lang.*;

public class KingandSons {
	
	public long Binomial(int n, int k) {
		
		if(k == 0 || k == n) return 1;
		
		else return Binomial(n - 1, k - 1) + Binomial(n - 1, k);
		
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K = s.nextInt();
		
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		
		KingandSons k = new KingandSons();
		
		
	}
}
