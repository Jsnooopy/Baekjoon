package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1389 {
	static int N, M;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) distance[i][j] = 0;
				else distance[i][j] = 10000001;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			distance[A][B] = 1;
			distance[B][A] = 1;
		}
		
		int[] kevinNum = new int[N + 1];
		Arrays.fill(kevinNum, 0);
		
		floyd();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				
				if(distance[i][j] != 0) {
					kevinNum[i] += distance[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			min = Math.min(min, kevinNum[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(min == kevinNum[i]) {
				System.out.println(i);
				break;
			}
		}
		
	} // main
	
	static void floyd() {
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
	} // floyd

} // class
