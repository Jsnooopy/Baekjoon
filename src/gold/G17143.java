package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G17143 {

  static class Shark {

    int nr, nc, s, d, z;

    Shark(int nr, int nc, int s, int d, int z) {
      this.nr = nr;
      this.nc = nc;
      this.s = s;
      this.d = d;
      this.z = z;
    }
  }

  static int R, C, M;
  static Shark[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new Shark[R + 1][C + 1];
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      board[r][c] = new Shark(r, c, s, d, z);
    }

    int where = 0;
    int result = 0;
    while (where <= C) {
      where++;
      if(where > C) break;

      result += get(where);
      move();
    }

    System.out.println(result);
  } // main

  static void move() {
    ArrayList<Shark> list = new ArrayList<>();

    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        if (board[i][j] != null) {
          list.add(board[i][j]);
        }
      }
    }

    board = new Shark[R + 1][C + 1];
    for (int i = 0; i < list.size(); i++) {
      Shark shark = list.get(i);
      int nr = shark.nr;
      int nc = shark.nc;
      int s = shark.s;
      int d = shark.d;
      int z = shark.z;

      if (d == 1) nr -= s;
      else if (d == 2) nr += s;
      else if (d == 3) nc += s;
      else nc -= s;

      while (nr < 1 || nr > R) {
        if (d == 1) {
          nr = 2 - nr;
          d = 2;
        } else if (d == 2) {
          nr = 2 * R - nr;
          d = 1;
        }
      }

      while (nc < 1 || nc > C) {
        if (d == 3) {
          nc = 2 * C - nc;
          d = 4;
        } else if (d == 4) {
          nc = 2 - nc;
          d = 3;
        }
      }

      if (board[nr][nc] == null) {
        board[nr][nc] = new Shark(nr, nc, s, d, z);
      } else {
        if (board[nr][nc].z < z) {
          board[nr][nc] = new Shark(nr, nc, s, d, z);
        }
      }
    }
  } // move

  static int get(int now) {
    for (int i = 1; i <= R; i++) {
      if(board[i][now] != null){
        int size = board[i][now].z;
        board[i][now] = null;
        return size;
      }
    }
    return 0;
  } // get


} // class
