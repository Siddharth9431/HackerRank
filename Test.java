import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		boolean[][] inputArr = new boolean[m][n];
		
		sc.nextLine();
		
		for(int i = 0; i < m ; i++) {
			
			String l = sc.nextLine();
			
			for(int j = 0; j < n; j++) {
				char c = l.charAt(j);
				
				if(c == '.') {
					inputArr[i][j] = true;
				}
				else {
					inputArr[i][j] = false;
				}
			}
		}
		
		int[][] upArr = new int[m][n];
		int[][] leftArr = new int[m][n];
		
		//Filling the upArr
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && inputArr[i][j] == true) {
					upArr[i][j] = 0;
				}
				if(i > 0) {
					if(upArr[i - 1][j] > -1) {
						upArr[i][j] = upArr[i - 1][j] + 1;
					}
				}
				if(inputArr[i][j] == false) {
					upArr[i][j] = -1;
				}
			}
		}
		
		
		
		//Filling the leftArr
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i == 0 && inputArr[j][i] == true) {
					leftArr[j][i] = 0;
				}
				if(i > 0) {
					if(leftArr[j][i - 1] > -1) {
						leftArr[j][i] = leftArr[j][i - 1] + 1;
					}
				}
				if(inputArr[j][i] == false) {
					leftArr[j][i] = -1;
				}
			}
		}
		
		int[][] perimeter = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				perimeter[i][j] = -1;
			}
		}
		
		int tempUP = 0;
		int tempL = 0;
		
		for(int i1 = m -1; i1 >= 0; i1-- ) {
			for(int j1 = n - 1; j1 >= 0; j1--) {
				
				tempUP = upArr[i1][j1];
				tempL = leftArr[i1][j1];
				
				
				int MaxPerimeter = 0;
				
				if(tempL > 0) {
					for(int i2 = 0; i2 < tempUP; i2++) {
						for(int j2 = 0; j2 < tempL; j2++) {
							int flag = 0;
							
							if(upArr[i1][j1 - tempL + j2] < (tempUP - i2)) {
								flag = 1;
							}
							
							if(leftArr[i1 - tempUP + i2][j1] < (tempL - j2)) {
								flag = 1;
							}
													
							
							if(flag == 0) {
								int tempPerimeter = 2 * ((tempUP - i2) + (tempL - j2));
								if(tempPerimeter > MaxPerimeter) {
									MaxPerimeter = tempPerimeter;
							
								}
							}
						}
					}
				}
				
				perimeter[i1][j1] = MaxPerimeter;
			}
		}
				
		int max = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(perimeter[i][j] > max) {
					max = perimeter[i][j];
				}
			}
		}
		
		
		if(max > 0) {
			System.out.println(max);
		} 
		else {
			System.out.println("impossible");
		}
		
	}
}
