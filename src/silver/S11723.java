package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11723 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int bitSet = 0;
		
		for(int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			
			int x = 0;
			if(!s[0].equals("all") && !s[0].equals("empty")) {
				x = Integer.parseInt(s[1]) - 1; // 0 ~ 19
			}
			
			switch(s[0]) {
			case "add":
				bitSet |= (1 << x);
				break;
			case "remove":
				bitSet &= ~(1 << x);
				break;
			case "check":
				sb.append((bitSet & (1 << x)) != 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				bitSet ^= (1 << x);
				break;
			case "all":
				bitSet = (1 << 20) - 1;
				break;
			case "empty":
				bitSet = 0;
				break;
			}
		}
		
		System.out.println(sb);
		
	} // main

} // class
