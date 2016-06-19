import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] adj = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < n; i++) {
			
			adj[i][i] = 0;
		}
		
		while(m-- > 0) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			
			adj[a][b] = c;
			
			
		}
		
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++) {
					if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
						if(adj[i][j] > adj[i][k] + adj[k][j])
							adj[i][j] = adj[i][k] + adj[k][j];
					}
				}
		
		
		
		int q = sc.nextInt();
		
		
		while(q-- > 0) {
			int startingN = sc.nextInt() - 1;
			int endingN = sc.nextInt() - 1;
			
			if(adj[startingN][endingN] == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(adj[startingN][endingN]);
			}
		}
	}
}
