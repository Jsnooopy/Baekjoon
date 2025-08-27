package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2630 {
	static int[][] arr;
	static int whitecnt, bluecnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(whitecnt);
		System.out.println(bluecnt);

	} // main
	
	static void divide(int x, int y, int size) {
		
		if(check(x, y, size)) {
			if(arr[x][y] == 0) whitecnt++;
			else bluecnt++;
			return;
		}
		
		int nsize = size / 2;
		
		divide(x, y, nsize); // 1사분면
		divide(x + nsize, y, nsize); // 2사분면
		divide(x, y + nsize, nsize); // 3사분면
		divide(x + nsize, y + nsize, nsize); // 4사분면
	} // divide
	
	static boolean check(int x, int y, int size) {
		int color = arr[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	} //check

} // class
