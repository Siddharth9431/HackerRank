import java.util.Scanner;

public class AngryProfessor {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int h = 0; h < T; h++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arrT = new int[N];
			
			for(int i = 0; i < N; i++) {
				arrT[i] = sc.nextInt();
			}
			
			
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				if(arrT[i] <= 0) count++;
			}
		
			if(count >= K) {
				System.out.println("NO");
			}
			if(count < K) {
				System.out.println("YES");
			}
			
		}
	
	}
}
