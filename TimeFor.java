import java.util.Arrays;
import java.util.Scanner;

public class TimeFor {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        char[] c = time.toCharArray();
        
        int pt1 = 0;
        int pt2 = 0;
        
        if(c[8] == 'P') {
        	pt1 = Character.getNumericValue(c[0]);
        	pt2 = Character.getNumericValue(c[1]);
        	
        	int time1 = pt1 * 10 + pt2;
        	
        	int timef = 00;
        	
        	if(time1 == 12) {
        		timef = time1;
        	} else
        		timef = time1 + 12;
        	
        	char[] c1 = Arrays.copyOfRange(c, 2, 8);
        	
        	
        	
        	String st2 = String.valueOf(c1);
        	
        	String fst1 = String.format("%02d", timef);
        	
        	System.out.println(fst1 + st2);
        }
        if(c[8] == 'A') {
        	pt1 = Character.getNumericValue(c[0]);
        	pt2 = Character.getNumericValue(c[1]);
        	
        	int time1 = pt1 * 10 + pt2;
        	
        	int timef = 00;
        	
        	if(time1 == 12) {
        		timef = 0;
        	} else
        		timef = time1;
        	
        	char[] c1 = Arrays.copyOfRange(c, 2, 8);
        	
        	
        	
        	String st2 = String.valueOf(c1);
        	
        	String fst1 = String.format("%02d", timef);
        	
        	System.out.println(fst1 + st2);
        }
    }
}
