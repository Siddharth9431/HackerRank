import java.util.Scanner;

public class FIndDigits {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int a0 = 0; a0 < t; a0++){
            int n = sc.nextInt();
            
            int length = (int) Math.log10(n) + 1;
            
            
            int[] digits = new int[length];
            
            int temp = n;
            
            int index = 0;
            
            while(temp > 0) {
            	
            	digits[index] = (temp % 10);
            	index++;
            	temp = temp / 10;
            }
            
            int count = 0;
            
            int num = n;
            
            for(int i = 0; i < length; i++) {
            	if(digits[i] != 0) {
            		if((num % digits[i]) == 0) count++;
            	}
            }
            
            System.out.println(count);
		}
	}
}
