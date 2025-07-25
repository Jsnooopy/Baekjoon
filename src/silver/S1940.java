package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int start = 0, end = 1;

        while (start != N - 1) {
            int sum = num[start] + num[end];
            if (sum == M) {
                cnt++;
            }

            if (end == N - 1) {
                start++;
                if (start == N - 1) {
                    continue;
                }
                end = start + 1;
            } else{
                end++;
            }
        }

        System.out.println(cnt);
    }
}
