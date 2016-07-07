import java.util.Scanner;

public class HackerCountry {
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] in = new int[N][N];
		int[][] D = new int[N + 1][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				in[i][j] = sc.nextInt();
			}
			in[i][i] = 1 << 30;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < N; j++) {
				D[i][j] = 1 << 29;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(D[i][k] + in[k][j] < D[i + 1][j]) {
						D[i + 1][j] = D[i][k] + in[k][j];
					}
				}
			}
		}
		
		double min = 1 << 30;
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++) {
			double delta = (double) (D[N][i] - D[0][i]) / N;
			
			int dx = D[N][i] - D[0][i];
			int dy = N;
			
			for(int j = 1; j < N; j++) {
				double alpha = (D[N][i] - D[j][i]) / ((double) (N - j));
				if(alpha > delta) {
					delta = alpha;
					dx = D[N][i] - D[j][i];
					dy = N - j;
				}
			}
			if(delta < min) {
				min = delta;
				x = dx;
				y = dy;
			}
		}
		
		int gcd = gcd(x, y);
		
		x = x / gcd;
		y = y / gcd;
		
		System.out.println(x + "/" + y);
	}
}
