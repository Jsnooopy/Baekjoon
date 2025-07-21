package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] S = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            S[i][0] = arr[i][0];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                S[i][j] = S[i][j - 1] + arr[i][j];
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int j = x1 - 1; j < x2; j++) {
                if (y1 == 1) {
                    sum += S[j][y2 - 1];
                } else {
                    sum += S[j][y2 - 1] - S[j][y1 - 2];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
