import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class EvenTree {
	static boolean[] visit = new boolean[200];
	static int ans = 0;
	static int dfs(ArrayList<ArrayList<Integer>> adj, int n, int v) {
		visit[v] = true;
		int numV = 0;
		Iterator<Integer> it1 = adj.get(v).iterator();
		while(it1.hasNext()) {
			int temp = it1.next();
			if(!visit[temp]) {
				int numN = dfs(adj, n, temp);
				if(numN % 2 == 0) {
					ans++;
				}
				else
					numV = numV + numN;
			}
		}
		return numV + 1;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
		
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			int v = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			
			adj.get(v).add(u);
			adj.get(u).add(v);
		}
		
		dfs(adj, n, 0);
		System.out.println(ans);
		
	}
}
