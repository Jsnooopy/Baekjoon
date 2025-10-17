package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17822 {

  static int N, M, T;
  static int[][] board;
  static boolean[][] same;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    same = new boolean[N + 1][M + 1];
    board = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (T > 0) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      rotate(x, d, k);
      revise();
      T--;
    }

    int result = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if(board[i][j] != 0) {
          result += board[i][j];
        }
      }
    }

    System.out.println(result);
  } // main

  static void rotate(int num, int direction, int time) {
    // 시계 방향 회전
    for (int i = num; i <= N; i += num) {
      if (direction == 0) {
        for(int k = 0; k < time; k++) {
          int temp = board[i][M];
          for (int j = M; j > 1; j--) {
            board[i][j] = board[i][j - 1];
          }
          board[i][1] = temp;
        }
      }
      // 반시계 방향 회전(M - time 만큼 시계 방향 회전)
      else {
        for(int k = 0; k < time; k++) {
          int temp = board[i][1];
          for (int j = 1; j < M; j++) {
            board[i][j] = board[i][j + 1];
          }
          board[i][M] = temp;
        }
      }
    }
  } // rotate

  static void revise() {
    // 인접하면서 같은 수 찾기
    boolean flag = false;

    for (int i = 1; i < N; i ++) {
      for (int j = 1; j <= M; j++) {
        if(board[i][j] == 0) continue;

        if (board[i][j] == board[i + 1][j]) {
          same[i][j] = true;
          same[i + 1][j] = true;
          flag = true;
        }
      }
    }

    for (int i = 1; i <= N; i ++) {
      for (int j = 1; j <= M; j++) {
        if (j != M) {
          if(board[i][j] == 0) continue;

          if (board[i][j] == board[i][j + 1]) {
            same[i][j] = true;
            same[i][j + 1] = true;

            flag = true;
          }
        } else {
          if(board[i][j] == 0) continue;

          if (board[i][M] == board[i][1]) {
            same[i][M] = true;
            same[i][1] = true;

            flag = true;
          }
        }
      }
    }

    // 같은 수 있으면
    if (flag) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          if (same[i][j]) {
            board[i][j] = 0;
            same[i][j] = false;
          }
        }
      }
    }
    // 같은 수 없으면
    else {
      int sum = 0;
      int cnt = 0;

      // 전체 수 평균 구하기
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          if(board[i][j] != 0) {
            sum += board[i][j];
            cnt++;
          }
        }
      }

      double avg = (double) sum / (double) cnt;

      // 평균보다 작으면 +1, 크면 -1
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          if(board[i][j] != 0) {
            if(board[i][j] > avg) board[i][j]--;
            else if(board[i][j] < avg) board[i][j]++;
          }
        }
      }
    }
  }

} // class
