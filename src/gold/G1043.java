package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G1043 {
	static int[] parent, truePeople;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		truePeople = new int[T];
		for(int i = 0; i < T; i++) {
			truePeople[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();
			int partySize = Integer.parseInt(st.nextToken());
			for(int j = 0; j < partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		parent = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			int first = party[i].get(0);
			for(int j = 1; j < party[i].size(); j++) {
				union(first, party[i].get(j));
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			boolean result = true;
			for(int j = 0; j < truePeople.length; j++) {
				if(find(party[i].get(0)) == find(truePeople[j])) {
					result = false;
					break;
				}
			}
			if(result) cnt++;
		}
		
		System.out.println(cnt);
	} // main
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
	
	static int find(int num) {
		if(num == parent[num]) return num;
		else return parent[num] = find(parent[num]);
	}
} // class
