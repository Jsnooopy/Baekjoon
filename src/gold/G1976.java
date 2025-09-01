package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1976 {
	static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] city = new int[N + 1][N + 1];
		parent = new int[N + 1];
		int[] path = new int[M + 1];
		for(int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N + 1; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < M + 1; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean result = true;
		for(int i = 2; i < M + 1; i++) {
			if(!check(path[1], path[i])) {
				result = false;
				break;
			}
		}
		
		if(result) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static boolean check(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		else return false;
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
	
	static int find(int num) {
		if(num == parent[num]) return num;
		else return parent[num] = find(parent[num]);
	}

}
