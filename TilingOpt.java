import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class TilingOpt {
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
		
		int maximum_Perimeter = Integer.MIN_VALUE;
		
		for(int i1 = 0; i1 < m; i1++) {
			for(int i2 = i1 + 1; i2 < m; i2++) {
				List<Integer> L = new ArrayList<Integer>();
				
				int height = i2 - i1;
				
				for(int j1 = 0; j1 < n; j1++) {
					if(upArr[i2][j1] >= height)
						L.add(j1);
				}
				
				int left = 0;
				for(int k = 0; k < L.size(); k++) {
					int left_Limit = L.get(k) - Math.min(leftArr[i1][L.get(k)], leftArr[i2][L.get(k)]);
					
					while(L.get(left) < left_Limit)
						left++;
					if(L.get(k) > L.get(left)) {
						maximum_Perimeter = Math.max(maximum_Perimeter, 2 *(height + (L.get(k) - L.get(left))));
					}
				}
			}
		}
		
		if(maximum_Perimeter < 0)
			System.out.println("impossible");
		else
			System.out.println(maximum_Perimeter);
		
	}
}
