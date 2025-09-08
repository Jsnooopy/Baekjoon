package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G11779 {
	
	static class City implements Comparable<City>{
		int end, cost;
		
		City(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(City c) {
			return this.cost > c.cost ? 1 : -1;
		}
	}
	
	static int n, m;
	static int[] distance, path;
	static ArrayList<City>[] list;
	static ArrayList<Integer> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		result = new ArrayList<>();
		path = new int[n + 1];
		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new City(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		go(s, e);
		
	}
	
	static void go(int s, int e) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(s, 0));
		distance[s] = 0;
		
		while(!pq.isEmpty()) {
			City now = pq.poll();
			
			if(now.cost > distance[now.end]) continue;
			
			for(int i = 0; i < list[now.end].size(); i++) {
				City city = list[now.end].get(i);
				int next = city.end;
				int cost = city.cost;
				
				if(distance[next] > distance[now.end] + cost) {
					distance[next] = distance[now.end] + cost;
					path[next] = now.end;
					pq.add(new City(next, distance[next]));
					
				}
			}
			
		}
		
		sb.append(distance[e]).append("\n");
		for(int i = e; i != s; i = path[i]) {
			result.add(i);
		}
		result.add(s);
		
		sb.append(result.size()).append("\n");
		for(int i = result.size() - 1; i >= 0; i--) {
			sb.append(result.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}

}
