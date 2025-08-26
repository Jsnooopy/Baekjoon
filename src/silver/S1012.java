package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1012 {
	static int M, N, K, cnt;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			visit = new boolean[N][M];
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[y][x] = 1;
			}
			
			cnt = 0;
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(!visit[j][k] && arr[j][k] == 1) {
						dfs(j, k);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);

	} // main

	static void dfs(int height, int width) {
		visit[height][width] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = width + dx[i];
			int ny = height + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || arr[ny][nx] == 0) {
				continue;
			}
	
			dfs(ny, nx);
		}
	} // dfs
	
} // class
