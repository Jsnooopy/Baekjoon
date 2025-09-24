package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int cnt = 0;
		int n = 0;
		while(K > 0) {
			int temp = 0;
			for(int i = n; i < N; i++) {
				if(arr[i] <= K) {
					temp = arr[i];
					n = i;
					break;
				}
			}
			
			while(K >= temp) {
				K -= temp;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
