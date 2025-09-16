package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1202 {
	
	static class Jewelry{
		int mass, price;
		
		Jewelry(int mass, int price){
			this.mass = mass;
			this.price = price;
		}
	}
	
	static int N, K;
	static Jewelry[] arr;
	static int[] bag;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new Jewelry[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new Jewelry(a, b);
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(a.mass == b.mass) return b.price - a.price;
			return a.mass - b.mass;
		});
		
		bag = new int[K];
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		
		long result = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		 
	    for(int i = 0, j = 0; i < K; i++) {
	        while(j < N && arr[j].mass <= bag[i]) {
	            pq.add(arr[j++].price);
	        }

	        if(!pq.isEmpty()) {
	            result += pq.poll();
	        }
	    }
	        
	    System.out.println(result);
	}

}
