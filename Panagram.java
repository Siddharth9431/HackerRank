import java.util.Arrays;
import java.util.Scanner;

public class Panagram {
		
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		
		
		String s = S.toLowerCase();
		
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);
		
		int flag = 0;
		
		for(char i = 'a'; i <= 'z'; i++) {
			if(Arrays.binarySearch(arr, i) < 0) {
				flag = 1;
			}
		}
		
		if(flag == 1) {
			System.out.println("not panagram");
		}
		
		if(flag == 0) {
			System.out.println("panagram");
		}
	}
}
