package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;

        while (true) {
            int e = year % 15;
            int s = year % 28;
            int m = year % 19;

            if (e == 0) {
                e = 15;
            }
            if (s == 0) {
                s = 28;
            }
            if (m == 0) {
                m = 19;
            }

            if (e == E && s == S && m == M) {
                break;
            }
            year += 1;
        }

        System.out.println(year);
    }
}
