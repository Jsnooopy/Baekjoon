package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2281 {
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for(int i = n - 1; i > -1; i--){
            int length = 0;
            for(int j = i; j < n; j++){
                length += arr[j];
                if(j > i) length += 1;
                if(length > m) break;
                
                int cost;
                if(j == n - 1) cost = 0;
                else cost = (int) Math.pow(m - length, 2);
                dp[i] = Math.min(dp[i], cost + dp[j + 1]);
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(dp[0]));
        System.out.println(sb);
	}

}
