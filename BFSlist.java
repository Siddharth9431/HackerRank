import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFSlist {
	public static int[] BFS(LinkedList<Integer>[] a, int s, int n) {
		int start = s - 1;
		int[] lengths = new int[n];
		boolean[] v = new boolean[n];
		
		
		v[start] = true;
		
		for(int i = 0; i < n; i++) {
			if(i == start) {
				Iterator<Integer> it1 = a[i].iterator();
				
				while(it1.hasNext()) {
					lengths[it1.next()] = 6;
				}
			}			
		}
		LinkedList<Integer> l = a[start];
		
		while(l.size() > 0) {
			int node = l.removeFirst();
			
			v[node] = true;
			
			for(int i = 0; i < n; i++) {
				if(!v[i] && a[node].contains(i)) {
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
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int E = sc.nextInt();
			
			LinkedList<Integer>[] al = new LinkedList[N];
			
			for(int i = 0; i < N; i++) {
				al[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				al[x - 1].add(y - 1);
				al[y - 1].add(x - 1);
			}
						
			int s =  sc.nextInt();
			
			int[] length = BFS(al, s, N);
			
			String output = "";
			
			for(int i = 0; i < N; i++) {
				if(i != s - 1) {
					output = output + (length[i] == 0 ? -1 : length[i]) + " ";
				}				
			}
			output = output.trim();
			System.out.println(output);
			
		}
	}
}
