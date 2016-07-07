import java.math.BigInteger;
import java.util.Scanner;

public class BeadOrnament {
	
	static BigInteger modv = BigInteger.valueOf(1000000007);
	
	static BigInteger cayley(int n) {
		if(n <= 2) {
			return BigInteger.ONE;
		}
		return BigInteger.valueOf(n).pow(n - 2);
	}
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			
			int[] noBeads = new int[N];
			
			BigInteger sum = BigInteger.valueOf(0);
			BigInteger product = BigInteger.valueOf(1);
			
			for(int i = 0; i < N; i++) {
				noBeads[i] = sc.nextInt();
				sum = sum.add(BigInteger.valueOf(noBeads[i]));
				product = product.multiply(BigInteger.valueOf(noBeads[i]));
			}
			
			BigInteger sumPow = BigInteger.valueOf(1);
			
			if(N > 1) {
				sumPow = sum.pow(N - 2);
			}
			
			BigInteger temp = BigInteger.valueOf(1);
			
			for(int k : noBeads) {
				temp = temp.multiply(cayley(k));
			}
			
			BigInteger ans = temp.multiply(sumPow).multiply(product);
			
			ans = ans.mod(modv);
			if(N > 1) {
				System.out.println(ans);
			}
			else {
				System.out.println(cayley(noBeads[0]));
			}
		}
	}
}
