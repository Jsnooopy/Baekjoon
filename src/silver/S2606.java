package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2606 {
	static int[][] arr;
	static boolean[] visit;
	static int C, N, cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());	
		arr = new int[C + 1][C + 1];
		visit = new boolean[C + 1];
		cnt = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(1);

		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		visit[start] = true;
		
		for(int i = 1; i <= C; i++) {
			if(arr[start][i] == 1 && !visit[i]) {
				cnt++;
				dfs(i);
			}
		}
	}

}
