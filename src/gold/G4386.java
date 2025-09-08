package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G4386 {
	
	static class Where{
		double x, y;
		
		Where(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Star{
		int start, end;
		double cost;
		
		Star(int start, int end, double cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int[] parent;
	static int n;
	static ArrayList<Star> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		Where[] star = new Where[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			star[i] = new Where(x, y);
		}
		
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			Where star1 = star[i];
			for(int j = 0; j < n; j++) {
				Where star2 = star[j];
				double cost = Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
				list.add(new Star(i, j, cost));
			}
		}
		
		Collections.sort(list, Comparator.comparingDouble(e -> e.cost));
		
		double result = 0;
		for(Star s : list) {
			if(find(s.start) != find(s.end)) {
				union(s.start, s.end);
				result += s.cost;
			}
		}
		
		String formatted = String.format("%.2f", result);
		System.out.println(formatted);
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
