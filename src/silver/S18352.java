package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S18352 {
	static ArrayList<Integer>[] A;
	static List<Integer> answer = new ArrayList<>();
	static int[] visit;
	static int depth, N, M, K, X;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			A[a].add(b);		
		}
		
		visit = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			visit[i] = -1;
		}
		
		bfs(X);
		
		for(int i = 1; i <= N; i++) {
			if(visit[i] == K) answer.add(i);
		}
		
		Collections.sort(answer);
		
		if(answer.isEmpty()) sb.append(-1).append("\n");
		else {
			for(int val : answer) {
				sb.append(val).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start]++;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : A[now]) {
				if(visit[i] == -1) {
					visit[i] = visit[now] + 1;
					q.add(i);
				}
			}
		}
		
	}

}
