package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3079 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] T = new long[N];
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      T[i] = Long.parseLong(br.readLine());
      min = Math.min(min, T[i]);
      max = Math.max(max, T[i]);
    }

    Arrays.sort(T);
    max *= M;

    while (min <= max) {
      long mid = (max + min) / 2;

      long cnt = 0;
      for (int i = 0; i < N; i++) {
        cnt += mid / T[i];
        if(cnt > M) break;
      }

      if(cnt < M) min = mid + 1;
      else max = mid - 1;
    }

    System.out.println(min);
  }

}
