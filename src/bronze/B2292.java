package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		
		while(n > 0) {
			int x = (i++) * 6;
			n -= x;
		}
		
		System.out.println(i);
	}

}
