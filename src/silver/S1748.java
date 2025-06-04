package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int plus = 1;
        int divide = 10;

        for (int i = 1; i <= N; i++) {
            if (i % divide == 0) {
                plus++;
                divide *= 10;
            }
            cnt += plus;
        }
        System.out.println(cnt);
    }
}
