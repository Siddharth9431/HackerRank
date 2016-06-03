import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSubA {
	
	public int contiguous(int[] a) {
		
		
		
		int maxSum = 0;
		int currentSum = 0;
		
		for(int i = 0; i < a.length; i++) {
			currentSum = currentSum + a[i];
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
			}
			
			if(currentSum < 0) {
				currentSum = 0;
			}
		}
		
		if(maxSum == 0) {
			Arrays.sort(a);
			return a[a.length - 1];
		}
		
		else return maxSum;
		
	}
	
	public int Noncontiguous(int[] a) {
		int sum = 0;
		
		Arrays.sort(a);
		
		if(a[a.length - 1] <=0) {
			sum = a[a.length - 1];
		}
		else {
			for(int i = 0; i < a.length; i++) {
				if(a[i] > 0) {
					sum = sum + a[i];
				}
			}
		}
		
		return sum;
	}

    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
    	
    	int t = sc.nextInt();
    	
    	int arrl;
    	
    	MaxSubA ma = new MaxSubA();
    	
    	for(int i  = 0; i < t; i++) {
    		arrl = sc.nextInt();
    		
    		int[] arr = new int[arrl];
    		
    		for(int k = 0; k < arr.length; k++) {
    			arr[k] = sc.nextInt();
    		}
    		
    		System.out.println(ma.contiguous(arr) + " " + ma.Noncontiguous(arr));
    		
    	}
    }
}