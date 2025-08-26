package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1303 {
	static char[][] arr;
	static boolean[][] visit;
	static int N, M, cnt, wcnt, bcnt;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M][N];
		visit = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					char color = arr[i][j];
					cnt = 1;
					dfs(j, i, color);
					
					if(color == 'W') {
						wcnt += cnt * cnt;
					} else {
						bcnt += cnt * cnt;
					}
					
				}
			}
		}
		
		System.out.println(wcnt + " " + bcnt);

	} // main
	
	static void dfs(int width, int height, char color) {
		visit[height][width] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = width + dx[i];
			int ny = height + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[ny][nx] || arr[ny][nx] != color) {
				continue;
			}
			cnt++;
			dfs(nx, ny, color);
			
		}
		
		
	} // dfs

} // class
