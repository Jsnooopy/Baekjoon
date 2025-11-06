package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2110 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int[] house = new int[N];
    for (int i = 0; i < N; i++) {
      house[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(house);

    int start = 1;
    int end = house[N - 1] - house[0];
    int result = 0;

    while (start <= end) {
      int mid = (start + end) / 2;

      int cnt = 1;
      int install = house[0];

      for (int i = 0; i < N; i++) {
        if (house[i] - install >= mid) {
          cnt++;
          install = house[i];
        }
      }

      if (cnt >= C) {
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(result);
  }

}
