import java.util.Scanner;

public class UtopianTree {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            
            int H = 1;
            
            int spring = 0;
            int summer = 0;
            
            if(n % 2 == 0) {
            	spring = n / 2;
            	summer = n / 2;
            }
            else {
            	spring = ((n / 2) + 1);
            	summer = n / 2;
            }
            
           while(spring > 0){
        	   
        	   
        	   if(spring > 0) {
               	H = 2 * H;
               	
               	if(summer > 0) {
               		
               		H = H + 1;
               		summer--;
               	}
               	
               	spring--;
               }
           }
           
           System.out.println(H);
            
        }
    }
}
