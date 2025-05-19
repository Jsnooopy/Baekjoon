package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            boolean prime = true;

            if (num == 1) {
                prime = false;
            }

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
