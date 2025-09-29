package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2096 {

	static int N;
	static int[][] arr, dp1, dp2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp1 = new int[N][3];
		dp2 = new int[N][3];
		arr = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j]  = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(Max() + " " + Min());
	}
	
	static int Max() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) dp1[i][j] = arr[i][j];
				else {
					if(j == 0) dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i - 1][j + 1]) + arr[i][j];
					else if(j == 1) dp1[i][j] = Math.max(Math.max(dp1[i - 1][j], dp1[i - 1][j + 1]), dp1[i - 1][j - 1]) + arr[i][j];
					else dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		
		return Math.max(Math.max(dp1[N - 1][0], dp1[N - 1][1]), dp1[N - 1][2]);
	}
	
	static int Min() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) dp2[i][j] = arr[i][j];
				else {
					if(j == 0) dp2[i][j] = Math.min(dp2[i - 1][j], dp2[i - 1][j + 1]) + arr[i][j];
					else if(j == 1) dp2[i][j] = Math.min(Math.min(dp2[i - 1][j], dp2[i - 1][j + 1]), dp2[i - 1][j - 1]) + arr[i][j];
					else dp2[i][j] = Math.min(dp2[i - 1][j], dp2[i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		
		return Math.min(Math.min(dp2[N - 1][0], dp2[N - 1][1]), dp2[N - 1][2]);
	}

}
