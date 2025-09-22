package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2467 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[2];
		int start = 0;
		int end = N - 1;
		int sum = arr[start] + arr[N - 1];
		int min = Integer.MAX_VALUE;
		
		while(start < end) {
			min = Math.min(Math.abs(sum), min);
			if(min == Math.abs(sum)) {
				result[0] = arr[start];
				result[1] = arr[end];
			}
			
			if(sum < 0) {
				sum -= arr[start];
				start++;
				sum += arr[start];
			} else {
				sum -= arr[end];
				end--;
				sum += arr[end];
			}
		}
		
		for(int a : result) {
			sb.append(a).append(" ");
		}
		
		System.out.println(sb);
	}

}
