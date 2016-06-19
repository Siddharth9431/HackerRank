import java.util.Arrays;
import java.util.Scanner;

public class Equal {
	
	public long steps(long temp) {
		long x = 0;
		
		if(temp >= 5) {
			x = temp / 5;
			temp = temp % 5;
		}
		
		if(temp >= 2) {
			x = x + temp / 2;
			temp = temp % 2;
		}
		x = x + temp;
		
		return x;
	}
	
	public static void main(String [] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			long[] A = new long[N];
			
			for(int j = 0; j < N; j++) {
				A[j] = sc.nextLong();
			}
			
			Arrays.sort(A);
			
			long min = A[0];
			
			long[] sum = new long[6];
			
			long temp = 0;
			
			Equal E = new Equal();
			
			for(int k = 0; k <= 5; k++) {
				for(int l = 0; l < N; l++) {
					temp = Math.abs(A[l] - (min - k));
					sum[k] = sum[k] + E.steps(temp); 
				}
			}
			
			Arrays.sort(sum);
			System.out.println(sum[0]);
		}		
	}
}
