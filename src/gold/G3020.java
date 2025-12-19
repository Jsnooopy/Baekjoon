package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H];
        int[] up = new int[H];

        for (int i = 0; i < N / 2; i++) {
            int d = Integer.parseInt(br.readLine()) - 1;
            int u = H - Integer.parseInt(br.readLine());

            down[d]++;
            up[u]++;
        }

        for (int i = H - 2; i >= 0; i--) {
            down[i] += down[i + 1];
        }
        for (int i = 1; i < H; i++) {
            up[i] += up[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            int d = down[i];
            int u = up[i];

            min = Math.min(min, d + u);
        }

        for (int i = 0; i < H; i++) {
            if(min == down[i] + up[i]) cnt++;
        }


        System.out.printf("%d %d%n", min, cnt);
    }

}
