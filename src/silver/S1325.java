package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1325 {
	
	static int N, M;
	static ArrayList<Integer>[] A;
	static boolean[] visit;
	static int[] result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		result = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			A[a].add(b);
		}
		
		for(int i = 1; i <= N; i++) {
			bfs(i);	 
			for(int j = 1; j <= N; j++) {
				visit[j] = false;
			}
		}
		
		int max = 0;
		
		for(int val : result) max = Math.max(val, max);
		
		for(int i = 1; i <= N; i++) {
			if(result[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	} // main

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int val : A[now]) {
				if(!visit[val]) {
					visit[val] = true;
					result[val]++;
					q.add(val);
				}
			}
		}
	} // bfs
	
} // class
