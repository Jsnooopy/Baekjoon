package gold; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G9251 {
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		char[] char1 = br.readLine().toCharArray();
		char[] char2 = br.readLine().toCharArray();
		
		int [][] dp = new int[char1.length + 1][char2.length + 1];
		
		for(int i = 1; i<=char1.length; i++) {
			for(int j = 1; j<=char2.length; j++) {
				if(char1[i - 1] == char2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println(dp[char1.length][char2.length]);
	}
}
