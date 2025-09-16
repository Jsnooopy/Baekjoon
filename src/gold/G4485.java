package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4485 {
	
	static int N;
	static int[][] cave, result;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			cnt++;
			
			if(N == 0) break;
			
			cave = new int[N][N];
			visit = new boolean[N][N];
			result = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(0, 0);
			
			System.out.println("Problem " + cnt + ": " + result[N - 1][N - 1]);
		}
		
	} // main

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		result[y][x] = cave[y][x];
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(result[ny][nx] > result[nowY][nowX] + cave[ny][nx]) {
					result[ny][nx] = result[nowY][nowX] + cave[ny][nx];
					q.add(new int[] {nx, ny});
				}
			}
			
		}
	} // bfs
	
} // class
