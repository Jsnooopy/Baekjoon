package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2473 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE;
		long[] result = new long[3];
		
		for(int i = 0; i < N; i++) {
			int start = i;
			int mid = i + 1;
			int end = N - 1;
			
			while(mid < end) {
				long sum = arr[start] + arr[mid] + arr[end];
				
				min = Math.min(Math.abs(sum), min);
				if(min == Math.abs(sum)) {
					result[0] = arr[start];
					result[1] = arr[mid];
					result[2] = arr[end];
				}
				
				if(sum < 0) {
					mid++;
				} else {
					end--;
				}
			}
		}
		
		for(long a : result) sb.append(a).append(" ");
		
		System.out.println(sb);
		
	}

}
