package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1743 {

	static int cnt, N, M, K, result;
	static boolean[][] gar;
	static int[][] arr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		gar = new boolean[N + 1][M + 1];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			arr[y][x] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!gar[i][j] && arr[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					
					result = Math.max(result, cnt);
				}
				
			}
		}
		
		System.out.println(result);

	}
	
	static void dfs(int height, int width) {
		gar[height][width] = true;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int nx = width + dx[i];
			int ny = height + dy[i];
			
			if(nx <= 0 || ny <= 0 || nx > M || ny > N || gar[ny][nx] || arr[ny][nx] == 0) {
				continue;
			}
			
			dfs(ny, nx);
		}
	}

}
