import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class EdgeX implements Comparable<EdgeX> {

	int a;
	int b;
	int weight;
	
	
	EdgeX(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight; 
	}
	public int compareTo(EdgeX x) {
		
		return Integer.compare(x.weight, this.weight);
	}
	
}

public class Matrix {
	
	static int[] parentArr;
	static int[] count;
	
	static int findParent(int a) {
		if(parentArr[a] == a)
			return a;
		
		parentArr[a] = findParent(parentArr[a]);
		return parentArr[a];
	}
	
	static void unionSet(int a, int b) {
		int seta = findParent(a);
		int setb = findParent(b);
		parentArr[seta] = setb;
		count[setb] = count[setb] + count[seta]; 
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		EdgeX[] adj = new EdgeX[N - 1]; 
		
		parentArr = new int[N];
		count = new int[N];
		long result = 0;
		
		for(int i = 0; i < N; i++) {
			count[i] = 0;
			parentArr[i] = i;
		}
		
		for(int i = 0; i < N - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			adj[i] = new EdgeX(x, y, z);
			result = result + z;
		
		}
		
		for(int i = 0; i < K; i++) {
			int temp = sc.nextInt();
			count[temp] = 1;
		}
		Arrays.sort(adj);
		
		for(int i = 0; i < N - 1; i++) {
			int aP = findParent(adj[i].a);
			int bP = findParent(adj[i].b);
			int cW = adj[i].weight;
			
			if(aP != bP && !(count[aP] > 0 && count[bP] > 0)) {
				unionSet(aP, bP);
				result = result - cW;
			}
		}
		
		System.out.println(result);
	}
}
