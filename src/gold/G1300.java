package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G1300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		long start = 1;
		long end = k;
		long result = 0;
		
		while(start <= end) {
			long middle = (start + end) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N);
			}
			
			if(cnt < k) start = middle + 1;
			else {
				result = middle;
				end = middle - 1;
			}
		}
		
		System.out.println(result);
	}

}
