package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2638 {

	static class Cheese{
		int x, y;
		
		Cheese(int x, int y){
			this.x = x;
			this.y = y;
		}
	} // Cheese
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	static ArrayList<Cheese> list;
	
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) list.add(new Cheese(j, i));
			}
		}
		
		visit = new boolean[N][M];
		dfs(0, 0);
		
		int day = 0;
		while(!list.isEmpty()) {
			ArrayList<Cheese> melt = new ArrayList<>();
			
			for(Cheese c : list) {
				if(check(c.x, c.y)) melt.add(c);
			}
			
			for(Cheese c : melt) {
				arr[c.y][c.x] = 0;
				list.remove(c);
			}
			
			visit = new boolean[N][M];
			dfs(0, 0);
			
			day++;
		}
		
		System.out.println(day);
	} // main
	
	// 외부 공기 판별
	static void dfs(int x, int y) {
		arr[y][x] = 2;
		visit[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			
			if(!visit[ny][nx]) {
				if(arr[ny][nx] != 1) dfs(nx, ny);
			}
		}
		
	} // dfs

	static boolean check(int x, int y) {
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			
			if(arr[ny][nx] == 2) cnt++;
		}
		
		return cnt >= 2;
	} // check
	
} // class
