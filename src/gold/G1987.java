package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G1987 {

	static int R, C, result;
	static char[][] alpha;
	static boolean[] bet;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[R][C];
		bet = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				alpha[i][j] = s.charAt(j);
			}
		}
		
		bet[alpha[0][0] - 65] = true;
		dfs(0, 0, 1);
		
		System.out.println(result);
	} // main

	static void dfs(int x, int y, int depth) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
			
			if(!bet[alpha[ny][nx] - 65]) {
				bet[alpha[ny][nx] - 65] = true;
				dfs(nx, ny, depth + 1);
				bet[alpha[ny][nx] - 65] = false;
			}
		}
		
		result = Math.max(result, depth);
		return;
		
	}
	
} // class
