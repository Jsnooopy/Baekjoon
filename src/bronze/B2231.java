package bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int length = String.valueOf(N).length();
        int i = 0;

        for(i = Math.max(N - length * 9, 0); i < N; i++) {
            int sum = 0;
            String num = String.valueOf(i);
            for(int j = 0; j < num.length(); j++) {
                sum += Integer.parseInt(String.valueOf(num.charAt(j)));
            }
            sum += i;
            if(N == sum) break;
        }

        System.out.println(i == N ? 0 : i);
    }
}