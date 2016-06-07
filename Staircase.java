import java.util.Scanner;

public class Staircase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i = 0; i < n; i++) {
        	int k = (n - 1) - i;
        	int m = n - k;
        	while(k > 0) {
        		System.out.print(" ");
        		k--;
        	}
        	while(m > 0) {
        		System.out.print("#");
        		m--;
        	}
        	
        	System.out.println();
        }
        
    }
}
