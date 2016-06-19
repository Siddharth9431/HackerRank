import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

	int a;
	int b;
	int weight;
	
	Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight; 
	}
	public int compareTo(Edge x) {
		
		return Integer.compare(this.weight, x.weight);
	}
	
}

public class Prims {
	static int[] a1;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		a1 = new int[N + 1];
		
		ArrayList<ArrayList<Edge>> al = new ArrayList<ArrayList<Edge>>(N + 1);
		
		for(int i = 0; i < N + 1; i++) {
			al.add(new ArrayList<Edge>());
		}
		Arrays.fill(a1, -1);
		
		while(M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			
			Edge f = new Edge(a, b, weight);
			
			al.get(a).add(new Edge(a, b, weight));
			al.get(b).add(new Edge(b, a, weight));
		}
		
		int s = sc.nextInt();
		int count = 0;
		int sum = 0;
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Iterator<Edge> it = al.get(s).iterator();
		
		while(it.hasNext()) {
			pq.add(it.next());
		}
		
		while(count != N - 1) {
			
			Edge currentEdge = pq.remove();
		
			
			int a = currentEdge.a;
			int b = currentEdge.b;
			if(gP(a) != gP(b)) {
				count++;
				sum = sum + currentEdge.weight;
				U(a,b);
				
				Iterator<Edge> it2 = al.get(b).iterator();
				while(it2.hasNext()) {
					pq.add(it2.next());
				}
			}
		}
		
		System.out.println(sum);
	}
	static int gP(int k) {
		while(a1[k] != -1) {
			k = a1[k];
		}
		return k;		
	}
	
	static void U(int a2, int a3) {
		a1[gP(a3)] =  gP(a2);
	}
}
