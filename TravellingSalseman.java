import java.util.Scanner;

public class TravellingSalseman {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] verticalDist = new int[m][n - 1];
		int[][] horizontalDist = new int[m -1][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n - 1; j++) {
				verticalDist[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < m - 1; i++) {
			for(int j = 0; j < n; j++) {
				horizontalDist[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
