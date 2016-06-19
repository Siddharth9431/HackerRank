import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {

	int v, c;
	
	Node(int v, int c) {
		this.v = v;
		this.c = c;
	}
	
	public int compareTo(Node x) {
		
		int h = Integer.compare(this.c, x.c);
		
		return h;
	}
	
}
public class Dijkstra {
	static void path(int s, ArrayList<ArrayList<Node>> al, int n) {
		int[] distance = new int[n + 1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[s] = 0;
		
		PriorityQueue<Node> p = new PriorityQueue<Node>();
		
		p.add(new Node(s, 0));
		
		while(p.size() > 0) {
			Node current = p.peek();
			p.remove();
			
			int currentNode = current.v;
			
			Iterator<Node> it1 = al.get(currentNode).iterator();
			
			while(it1.hasNext()) {
				Node temp = it1.next();
				
				if(distance[temp.v] > distance[currentNode] + temp.c) {
					p.add(new Node(temp.v, temp.c + distance[currentNode]));
					distance[temp.v] = distance[currentNode] + temp.c;
				}
			}
		}
		for(int i = 1; i < distance.length; i++) {
			if(i != s)
				System.out.print((distance[i] == Integer.MAX_VALUE) ? -1 : distance[i] + " ");
		}
		System.out.println();
	}
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			ArrayList<ArrayList<Node>> al = new ArrayList<ArrayList<Node>>(N + 1);
			
			for(int i = 0; i < N + 1; i++) {
				al.add(new ArrayList<Node>(N + 1));
			}
			
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				
				al.get(x).add(new Node(y, z));
				al.get(y).add(new Node(x, z));
			}
			
			int S = sc.nextInt();
			path(S, al, N);
		}
	}
}
