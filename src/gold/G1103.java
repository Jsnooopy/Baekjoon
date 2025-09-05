package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1103 {
	
	static int N, M, result;
	static boolean inf;
	static int[][] board;
	static int[][] dp;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visit = new boolean[N][M];
		dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j) == 'H') board[i][j] = 0;
				else board[i][j] = s.charAt(j) - 48;
			}
		}
		
		dfs(0, 0, 1);
		
		if(inf) System.out.println(-1);
		else System.out.println(result);
	}
	
	static void dfs(int n, int m, int depth) {
		if(inf) return;
		
		if(dp[n][m] >= depth) return;
		dp[n][m] = depth;
		
		visit[n][m] = true;
		result = Math.max(result, depth);
		
		for(int i = 0; i < 4; i++) {
			int x = board[n][m];
			int[] dx = {0, 0, -x, x}, dy = {-x, x, 0, 0};
			
			int nx = m + dx[i];
			int ny = n + dy[i];
			
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			if(board[ny][nx] == 0) continue;
			
			if(visit[ny][nx]) {
				inf = true;
				return;
			} else {
				dfs(ny, nx, depth + 1);
			}
		}
		
		visit[n][m] = false;
	}

}
