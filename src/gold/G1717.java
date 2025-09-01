package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1717 {
	static int[] N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		N = new int[n + 1];
		for(int i = 0; i < n + 1; i++) {
			N[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			UF(w, a, b);
		}
	} // main

	static void UF(int what, int a, int b) {
		if(what == 0) {
			a = find(a);
			b = find(b);
			if(a != b) N[b] = a;
		} else if(what == 1) {
			a = find(a); 
			b = find(b);
			
			if(a == b) System.out.println("yes");
			else System.out.println("no");
		}
	} // UF
	
	static int find(int num) {
		if(num == N[num]) return num;
		else return N[num] = find(N[num]);
	}
}
