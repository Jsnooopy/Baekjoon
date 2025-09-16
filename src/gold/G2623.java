package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2623 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		int[] inDegree = new int[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					list[arr[j]].add(arr[k]);
					inDegree[arr[k]]++;
				}
			}
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) q.add(i);
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			sb.append(now).append("\n");
			for(int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				inDegree[next]--;
				if(inDegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if(cnt == N) System.out.println(sb);
		else System.out.println(0);
		
	} // main

} // class
