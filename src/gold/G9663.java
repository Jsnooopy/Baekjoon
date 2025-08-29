package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G9663 {
	
	static int N, cnt;
	static int[] chess;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		chess = new int[N];
		
		dfs(0);
		
		System.out.println(cnt);
	} // main
	
	static void dfs(int row) {
		if(row == N) {
			cnt++;
			return;
		}
		
		for(int col = 0; col < N; col++) {
			if(isPossible(row, col)) {
				chess[row] = col;
				dfs(row + 1);
			}
		}
	} // dfs
	
	static boolean isPossible(int row, int col) {
		for(int i = 0; i < row; i++) {
			if(chess[i] == col) {
				return false;
			}
			if(Math.abs(row - i) == Math.abs(col - chess[i])) {
				return false;
			}
		}
		return true;
	}

} // class
