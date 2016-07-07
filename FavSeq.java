import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FavSeq {
	static final int MAX = 999999;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<ArrayList<Integer>> PG = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < MAX; i++) {
			PG.add(new ArrayList<Integer>());
		}
		
		boolean[] alpha = new boolean[MAX];
		int[] beta = new int[MAX];
		
		for(int i = 0; i < N; i++) {
			int K = sc.nextInt();
			int previousE = -1;
			
			for(int j = 0; j < K; j++) {
				int x = sc.nextInt();
				alpha[x] = true;
				if(j > 0) {
					PG.get(previousE).add(x);
					beta[x]++;
				}
				previousE = x;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < MAX; i++) {
			if(alpha[i] && (beta[i] == 0))
				pq.add(i);
		}
		
		StringBuffer ans = new StringBuffer();
		
		while(!pq.isEmpty()) {
			int temp = pq.poll();
			
			for(int gamma : PG.get(temp)) {
				beta[gamma]--;
				if(beta[gamma] == 0)
					pq.add(gamma);
			}
			
			ans.append(temp + " ");
		}
		System.out.println(ans);
	}
}
