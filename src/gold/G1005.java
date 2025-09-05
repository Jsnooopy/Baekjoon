package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1005 {
	
	static int[] spendTime, result;
	static int[] inDegree;
	static int N, K;
	static ArrayList<Integer>[] list;
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			inDegree = new int[N + 1];
			result = new int[N + 1];
			spendTime = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				spendTime[j] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList[N + 1];
			for(int j = 1; j <= N; j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j = 1; j <= K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				inDegree[b]++;
			}
			
			build();
			
			int arrive = Integer.parseInt(br.readLine());
			
			System.out.println(result[arrive] + spendTime[arrive]);
		}
	} // main

	static void build() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int j = 0; j < list[now].size(); j++) {
				int next = list[now].get(j);
				
				inDegree[next]--;
				result[next] = Math.max(result[next], result[now] + spendTime[now]); 
				
				if(inDegree[next] == 0) q.add(next);
			}
		}
	}
	
} // class
