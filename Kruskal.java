import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
	static int[] parentArr;
	
	static int findParent(int a) {
		if(parentArr[a] == -1)
			return a;
		return findParent(a);
	}
	
	static void unionSet(int a, int b) {
		int seta = findParent(a);
		int setb = findParent(b);
		
		parentArr[seta] = setb;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>(n + 1);
		
		parentArr = new int[n + 1];
		
		Arrays.fill(parentArr, -1);
		
		for(int i = 0; i < n + 1; i++) {
			adj.add(new ArrayList<Edge>());
		}
		
		while(m-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			adj.get(a).add(new Edge(a, b, c));
			adj.get(b).add(new Edge(b, a, c));
		}
		
		int s = sc.nextInt();
		
		int sum = 0;
		int count = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Iterator<Edge> it = adj.get(s).iterator();
		
		while(it.hasNext()) {
			pq.add(it.next());
		}
		
		while(count < n - 1) {
			Edge curr = pq.remove();
			
			int Va = curr.a;
			int Vb = curr.b;
			
			if(findParent(Va) != findParent(Vb)) {
				count++;
				sum = sum + curr.weight;
				unionSet(Va, Vb);
				
				Iterator<Edge> it2 = adj.get(Vb).iterator();
				while(it2.hasNext()){
					pq.add(it2.next());
				}
			}
		}
		System.out.println(sum);
	}
}
