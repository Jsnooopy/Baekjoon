package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14503 {

  static int N, M, count;
  static int[][] room;
  static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    room = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    clear(r, c, d);

    System.out.println(count);
  } // main

  static void clear(int row, int col, int dir) {
    if (room[row][col] == 0){
      room[row][col] = 2;
      count++;
    }


    boolean empty = false;
    for (int i = 0; i < 4; i++) {
      int nr = row + dr[i];
      int nc = col + dc[i];

      if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

      if (room[nr][nc] == 0) empty = true;
    }

    if (!empty) {
      if (dir == 0) {
        if (room[row + 1][col] != 1) clear(row + 1, col, dir);
        else return;
      } else if (dir == 1) {
        if (room[row][col - 1] != 1) clear(row, col - 1, dir);
        else return;
      } else if (dir == 2) {
        if (room[row - 1][col] != 1) clear(row - 1, col, dir);
        else return;
      } else {
        if (room[row][col + 1] != 1) clear(row, col + 1, dir);
        else return;
      }
    } else {
      if (dir == 0) dir = 3;
      else dir -= 1;

      if (dir == 0) {
        if(room[row - 1][col] == 0) clear(row - 1, col, dir);
        else clear(row, col, dir);
      } else if (dir == 1) {
        if(room[row][col + 1] == 0) clear(row, col + 1, dir);
        else clear(row, col, dir);
      } else if (dir == 2) {
        if(room[row + 1][col] == 0) clear(row + 1, col, dir);
        else clear(row, col, dir);
      } else {
        if(room[row][col - 1] == 0) clear(row, col - 1, dir);
        else clear(row, col, dir);
      }
    }
  } // clear

} // class
