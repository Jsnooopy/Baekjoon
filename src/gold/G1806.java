package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;
		
		while(end < N) {
			if(sum >= S) {
				min = Math.min(end - start + 1, min);
				sum -= arr[start];
				start++;
			} else {
				end++;
				if(end >= N) break;
				sum += arr[end];
			}
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}

}
