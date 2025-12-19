package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1117 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long W = Integer.parseInt(st.nextToken());
        long H = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        long num = c + 1;
        long result = 0;
        if (f <= W / 2) {
            for (int i = x1; i < x2; i++) {
                if(i < f) result += (2 * num) * (y2 - y1);
                else result += num * (y2 - y1);
            }
        } else {
            for (int i = x1; i < x2; i++) {
                if(i < W - f) result += (2 * num) * (y2 - y1);
                else result += num * (y2 - y1);
            }
        }

        System.out.println(H * W - result);
    }
}
