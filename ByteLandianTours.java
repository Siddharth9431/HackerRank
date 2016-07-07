import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ByteLandianTours {
	
	static boolean isLeaf(int i, ArrayList<ArrayList<Integer>> al) {
		return (al.get(i).size() < 2);
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int mod = 1000000007;

		long[] factorial = new long[10001];
		
		factorial[0] = 1;
		
		for(int i = 1; i < 10001; i++) {
			factorial[i] = (factorial[i - 1] * i) % mod;
		}
		
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();		
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N);
			
			for(int i = 0; i < N; i++) {
				adj.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < N - 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adj.get(a).add(b);
				adj.get(b).add(a);	
			}
			
			boolean noPath = false;
			long paths = 1;
			int temp = 0;
			
			for(int i = 0; i < N; i++) {
				int Inodes = 0;
				int Tnodes = 0;
				
				for(int j : adj.get(i)) {
					if(!isLeaf(j, adj)) {
						++Inodes;
					}
					else {
						++Tnodes;
					}
				}
				if(Inodes > 2) {
					noPath = true;
					break;
				}
				if(!isLeaf(i, adj)) {
					++temp;
				}
				paths = paths * factorial[Tnodes];
				paths = paths % mod;
			}
			
			if(noPath) {
				System.out.println(0);
				continue;
			}
			if(temp == 1) {
				System.out.println(paths);
			}
			else {
				System.out.println((2 * paths) % mod);
			}
		}
	}
}
