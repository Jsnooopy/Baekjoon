package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 1, cnt = 1;
        int start = 1, end = 1;

        while (end != N) {
            if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                sum += end;
            } else if (sum == N) {
                cnt++;
                end++;
                sum += end;
            }
        }

        System.out.println(cnt);
    }
}
