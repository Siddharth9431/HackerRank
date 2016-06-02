import java.util.Scanner;

public class DigD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        int i = 0;
        int j = 0;
        
        int d1 = 0;
        int d2 = 0;
        
        while(i < n && j < n) {
        	d1 = d1 + a[i][j];
        	i++;
        	j++;
        }
        
        int k = n - 1;
        int m = 0;
        while(k >= 0 && m < n) {
        	d2 = d2 + a[k][m];
        	k--;
        	m++;
        }
        
        int sum = d1 - d2;
        
        System.out.println(Math.abs(sum));
        
        
    }
}
