package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G15685 {

  static class Dragon{
    int x, y, dir, gen;

    public Dragon(int x, int y, int dir, int gen) {
      this.x = x;
      this.y = y;
      this.dir = dir;
      this.gen = gen;
    }
  }

  static int N, cnt;
  static boolean[][] board;
  static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    board = new boolean[101][101];
    ArrayList<Dragon> list1 = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      list1.add(new Dragon(x, y, d, g));
    }

    for (Dragon dragon : list1) {
      ArrayList<Integer> list2 = new ArrayList<>();
      list2.add(dragon.dir);

      for (int i = 0; i < dragon.gen; i++) {
        for (int j = list2.size() - 1; j >= 0; --j) {
          list2.add((list2.get(j) + 1) % 4);
        }
      }
      curve(dragon, list2);
    }

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if(board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) cnt++;
      }
    }

    System.out.println(cnt);
  } // main

  static void curve(Dragon dragon, ArrayList<Integer> list) {
    int x = dragon.x;
    int y = dragon.y;

    board[y][x] = true;

    for (int d : list) {
      x += dx[d];
      y += dy[d];

      board[y][x] = true;
    }
  } // curve

} // class
