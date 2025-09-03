package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854 {
	static int n, m, k;
	static int[][] distance;
	static PriorityQueue<Integer>[] q;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도시 개수
		m = Integer.parseInt(st.nextToken()); // 도로 개수
		k = Integer.parseInt(st.nextToken());
		
		distance = new int[n + 1][n + 1];
		q = new PriorityQueue[n + 1];
		
		Comparator<Integer> cp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1;
			}
		};
		
		for(int i = 0; i <= n; i++) {
			q[i] = new PriorityQueue<>(k, cp);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
				
			distance[a][b] = c;
		}
		
		
		go(1, 0);
		
		for(int i = 1; i <= n; i++) {
			if(q[i].size() < k) System.out.println(-1); 
			else System.out.println(q[i].peek());
		}
		
	} // main
	
	static void go(int start, int t) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(start, t));
		q[1].add(0);
		
		while(!pq.isEmpty()) {
			City now = pq.poll();

			for(int i = 1; i <= n; i++) {
				if(distance[now.arrive][i] != 0) {
					if(q[i].size() < k) {
						q[i].add(now.time + distance[now.arrive][i]);
						pq.add(new City(i, now.time + distance[now.arrive][i]));
					} else if(q[i].peek() > now.time + distance[now.arrive][i]) {
						q[i].poll();
						q[i].add(now.time + distance[now.arrive][i]);
						pq.add(new City(i, now.time + distance[now.arrive][i]));
					}
				}
			
			}
		}
	} // go
} // class

class City implements Comparable<City> {
	int arrive, time;
	
	 City(int arrive, int time){
		this.arrive = arrive;
		this.time = time;
	}
	
	public int compareTo(City c) {
		return this.time > c.time ? 1 : -1;
	}
}