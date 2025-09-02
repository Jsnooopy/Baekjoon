package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class G1916 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] distance = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		ArrayList<City>[] list = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[s].add(new City(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int finish = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<City> q = new PriorityQueue<>();
		
		q.add(new City(start, 0));
		distance[start] = 0;
		
		while(!q.isEmpty()) {
			City now = q.poll();
			int now_a = now.arrive;
			
			if(visit[now_a]) continue;
			
			visit[now_a] = true;
			
			for(int i = 0; i < list[now_a].size(); i++) {
				City temp = list[now_a].get(i);
				int next = temp.arrive;
				int cost = temp.cost;
				
				if(distance[next] > distance[now_a] + cost) {
					distance[next] = distance[now_a] + cost;
					q.add(new City(next, distance[next]));
				}
			}
		}
		
		System.out.println(distance[finish]);
	} // main

} // class

class City implements Comparable<City>{
	int arrive, cost;
	
	City(int arrive, int cost){
		this.arrive = arrive;
		this.cost = cost;
	}
	
	public int compareTo(City c) {
		if(this.cost > c.cost) return 1;
		else return -1;
	}
} // City