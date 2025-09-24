package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G10942 {
	
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) Arrays.fill(dp[i], -1);
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append(check(S, E)).append("\n");
		}
		
		System.out.println(sb);
		
		
	} // main

	static int check(int S, int E) {
		if(dp[S][E] != -1) return dp[S][E];
		
		if(arr[S] != arr[E]) return 0;
		
		if(E - S < 2) return dp[S][E] = (arr[S] == arr[E]) ? 1 : 0;
		
		return dp[S][E] = check(S + 1, E - 1);
		
		
	} // check
	
} // class
