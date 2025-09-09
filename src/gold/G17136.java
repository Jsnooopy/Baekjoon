package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17136 {

	static int[] use;
	static int[][] arr;
	static boolean[][] visit;
	static int total;
	static int result = Integer.MAX_VALUE;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		use = new int[5];
		visit = new boolean[10][10];
		arr = new int[10][10];
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) total++;
			}
		}
		
		search(0, 0);
		
		System.out.println(result != Integer.MAX_VALUE ? result : -1);
	} // main
	
	static void search(int x, int y) {
		if(total == 0) {
			int sum = 0;
			for(int val : use) {
				sum += val;
			}
			result = Math.min(result, sum);
			return;
		}
		
		if(x > 9 || y > 9) return;
		
		if(arr[y][x] == 1 && !visit[y][x]) {
			for(int i = 0; i < 5; i++) {
				if(use[i] >= 5) continue;
				
				if(isPaper(x, y, i)) {
					int cnt = (int) Math.pow(i + 1, 2);
					
					fill(x, y, i, true);
					total -= cnt;
					
					if(x == 9) search(0, y + 1);
					else search(x + 1, y);
					
					fill(x, y, i, false);
					total += cnt;
				}
			}
		} else {
			if(x == 9) search(0, y + 1);
			else search(x + 1, y);
		}
	} // search
	
	static void fill(int x, int y, int size, boolean flag) {
		for(int i = y; i <= y + size; i++) {
			for(int j = x; j <= x + size; j++) {
				visit[i][j] = flag;
			}
		}
		
		if(flag) use[size]++;
		else use[size]--;
	} // fill
	
	static boolean isPaper(int x, int y, int size) {
		for(int i = y; i <= y + size; i++) {
			for(int j = x; j <= x + size; j++) {
				if(i < 0 || j < 0 ||j > 9 || i > 9) return false;
				if(visit[i][j]) return false;
				if(arr[i][j] == 0) return false;
			}
		}
		return true;
	} // isPaper

} // class
