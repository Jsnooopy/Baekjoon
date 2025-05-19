package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long cnt5 = five(n) - five(n - m) - five(m);
        long cnt2 = two(n) - two(n - m) - two(m);

        System.out.println(Math.min(cnt5, cnt2));
    }

    static long five(long num) {
        long cnt = 0;

        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }
        return cnt;
    }

    static long two(long num) {
        long cnt = 0;

        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }
        return cnt;
    }
}
