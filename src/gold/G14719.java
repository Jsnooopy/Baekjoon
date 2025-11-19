package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14719 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    int[][] map = new int[H][W];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < W; i++) {
      int start = H - Integer.parseInt(st.nextToken());
      for (int j = start; j < H; j++) {
        map[j][i] = 1;
      }
    }

    int result = getResult(H, W, map);

    System.out.println(result);
  }

  private static int getResult(int H, int W, int[][] map) {
    int result = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W -1; j++) {
        if (map[i][j] == 1 && map[i][j+1] == 0) {
          int count = 0;
          while (true) {
            j++;
            if (j == W) {
              break;
            }
            if (map[i][j] == 1) {
              result += count;
              j--;
              break;
            }
            count++;
          }
        }
      }
    }
    return result;
  }

}
