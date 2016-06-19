import java.util.Arrays;
import java.util.Scanner;

public class SortingIntro {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		
		int i = Arrays.binarySearch(a, x);
		
		if(i > 0) {
			System.out.println(i);
		}
	}
}
