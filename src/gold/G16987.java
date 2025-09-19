package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G16987 {
	
	static class Egg{
		int S, W;
		
		Egg(int S, int W){
			this.S = S;
			this.W = W;
		}
	}
	
	static int N, result;
	static ArrayList<Egg> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			list.add(new Egg(S, W));
		}
		
		
		back(0, 0);
		
		System.out.println(result);
		
	} // main
	
	static void back(int hand, int cnt) {
		if(hand == N) {
			result = Math.max(result, cnt);
			return;
		}
		
		Egg now = list.get(hand);
		
		if(now.S <= 0) {
			back(hand + 1, cnt);
			return;
		}

		boolean hit = false;
		for(int i = 0; i < N; i++) {
			if(hand == i) continue;
			
			Egg next = list.get(i);
			
			if(next.S > 0) {
				hit = true;
				
				now.S -= next.W;
				next.S -= now.W;
				
				int broken = 0;
				if(now.S <= 0) broken++;
				if(next.S <= 0) broken++;
				
				back(hand + 1, cnt + broken);
				
				now.S += next.W;
				next.S += now.W;
			}
		}
		
		if(!hit) back(hand + 1, cnt);
	} // back

} // class
