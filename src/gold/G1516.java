package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1516 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] spend = new int[N + 1];
		int[] result = new int[N + 1];
		int[] degree = new int[N + 1];
		
		ArrayList<ArrayList<Integer>> building = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			building.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			spend[i] = Integer.parseInt(st.nextToken());
			boolean check = true;
			while(check) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					check = false;
					continue;
				}
				building.get(num).add(i);
				degree[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int val : building.get(now)) {
				degree[val]--;
				result[val] = Math.max(result[val], result[now] + spend[now]);
				if(degree[val] == 0) q.add(val);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + spend[i]).append("\n");
		}
		
		System.out.println(sb);
		
	} // main

} // class
