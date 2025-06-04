package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int max =  M * N / gcd(M, N);
            int year = x;

            while (year <= max) {
                int Y = year % N;
                if (Y == 0) {
                    Y = N;
                }

                if (Y == y) {
                    sb.append(year).append("\n");
                    break;
                }

                year += M;
            }
            if (year > max) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
