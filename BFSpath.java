
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BFSpath {
	
	public static int[] BFS(int C, int[][] AM, int N) {
		
		int[] lengths = new int[N];
		boolean[] visited = new boolean[N]	;
		
		List<Integer> l = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			if(AM[C - 1][i] != 0) {
				l.add(i);
				lengths[i] = lengths[i] + 6;
			}
		}
		visited[C - 1] = true;
		
		while(l.size() > 0) {
			int node = l.remove(0);
			
			visited[node] = true;
			for(int i = 0; i < N; i++ ) {
				if(!visited[i] && AM[node][i] != 0) {
					l.add(i);
					
					if(lengths[i] == 0) lengths[i] = lengths[node] + 6;
					if(lengths[i] > (lengths[node] + 6)) {
						lengths[i] = lengths[node] + 6;
					}
				}
			}
		}
		return lengths;
	}
	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int E = sc.nextInt();
			
			int[][] AM = new int[N][N];
		
			
			for(int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				AM[x - 1][y - 1] = 1;
				AM[y - 1][x - 1] = 1;
			}
							
			int S = sc.nextInt();
			
			int[] length = BFS(S, AM, N);
			
			String output = "";
			
			for(int i = 0; i < N; i++) {
				if(i != S - 1) {
					output = output + (length[i] == 0 ? -1 : length[i]) + " ";
				}				
			}
			output = output.trim();
			System.out.println(output);
		}		
	}
}
