package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G1106 {
	
	static class Cost{
		int cost, cus;
		
		Cost(int cost, int cus){
			this.cost = cost;
			this.cus = cus;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Cost[] city = new Cost[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			city[i] = new Cost(a, b);
		}
		
		int[] dp = new int[C + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i <= C; i++) {
			for(int j = 0; j < N; j++) {
				int need = Math.max(0, i - city[j].cus);
				dp[i] = Math.min(dp[i],	dp[need] + city[j].cost);
			}
		}
		
		System.out.println(dp[C]);
	}

}
