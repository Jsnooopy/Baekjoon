package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long max = 0;
		int[] height = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, height[i]);
		}
		
		long min = 1;
		long mid = 0;
		
		while(min <= max) {
			mid = (min + max) / 2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(height[i] > mid) {
					sum += height[i] - mid;
				}
			}
			
			if(sum < M) max = mid - 1;
			else if(sum >= M) min = mid + 1;
			
		}
		
		System.out.println(max);

	} // main

} // class
