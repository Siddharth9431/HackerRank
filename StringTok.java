import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTok {
	public static void main(String[] args) {
	 
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String delim = "[!,?.*_'@\\ ]+";
		
		s = s.trim();
		
		if(s.length() > 400000) {
			return;
		}
		
		if(s.length() == 0) {
			System.out.println(0);
			return;
		}
		
		else {
			String[] tok = s.split(delim);
			
			System.out.println(tok.length);
			
			for(int i = 0; i < tok.length; i++) {
				System.out.println(tok[i]);
			}
		}
 
	}
}
