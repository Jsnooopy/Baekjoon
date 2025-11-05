package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G8983 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    int[] shotPoint = new int[M];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      shotPoint[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(shotPoint);

    int cnt = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int start = 0;
      int end = M - 1;
      boolean kill = false;

      while (start <= end) {
        int mid = (start + end) / 2;
        int d = Math.abs(shotPoint[mid] - x) + y;

        if (d <= L) {
          kill = true;
          break;
        }

        if (shotPoint[mid] < x) start = mid + 1;
        else end = mid - 1;
      }

      if (kill) cnt++;
    }

    System.out.println(cnt);
  }

}
