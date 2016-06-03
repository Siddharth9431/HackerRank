import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        double plus = 0;
        double minus = 0;
        double zero = 0;
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] > 0) {
        		plus++;
        	}
        	if(arr[i] < 0) {
        		minus++;
        	}
        	if(arr[i] == 0) {
        		zero++;
        	}
        }
        
        double length = arr.length;
        
        double fplus = plus / length;
        double fminus = minus / length;
        double fzero = zero / length;
        
        System.out.printf("%.6f \n", fplus);
        System.out.printf("%.6f \n", fminus);
        System.out.printf("%.6f \n", fzero);
        
    }
}
