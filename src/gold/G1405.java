package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1405 {

	static int N;
	static double D;
	static double np = 1;
	static double[] pro;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		pro = new double[4];
		for(int i = 0; i < 4; i++) {
			pro[i] = Double.parseDouble(st.nextToken());
		}
		
		visit = new boolean[29][29];
		int x = 14;
		int y = 14;
		
		visit[y][x] = true;
		move(14, 14, 0);
		
		System.out.println(D);
	}
	
	static void move(int x, int y, int depth) {
		if(depth == N) {
			D += np;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(pro[i] == 0) continue;
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			double p = pro[i] / 100;
			
			if(visit[ny][nx]) continue;
			
			np *= p;
			visit[ny][nx] = true;
			move(nx, ny, depth + 1);
			visit[ny][nx] = false;
			np /= p;
		}
	}

}
