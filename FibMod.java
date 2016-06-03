import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibMod {

	public BigInteger fibm(int a, int b, int c) {
		
		BigInteger a1 = BigInteger.valueOf(a);
		BigInteger b1 = BigInteger.valueOf(b);
		
		if(c == 2) return b1;
		if(c == 1) return a1;
		
		else return fibm(a, b, c - 1).multiply(fibm(a, b, c - 1)).add(fibm(a, b, c - 2)); 
	}
	
    public static void main(String[] args) {
        
    	Scanner s = new Scanner(System.in);
        
        int A = s.nextInt();
        int B = s.nextInt();
        int N = s.nextInt();
        
        FibMod f1 = new FibMod();
        
        BigInteger l1 = f1.fibm(A, B, N);
        
        System.out.println(l1);
        
        s.close();
    }
}