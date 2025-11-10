package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G16235 {

  static int N, M, K;
  static int[][] A, now;
  static ArrayList<Integer>[][] tree;
  static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    now = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(now[i], 5);
    }

    A = new int[N][N];
    tree = new ArrayList[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tree[i][j] = new ArrayList<>();
      }
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int a = Integer.parseInt(st.nextToken());

      tree[x][y].add(a);
    }

    while (K > 0) {
      year();
      K--;
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tree[i][j] != null) {
          cnt += tree[i][j].size();
        }
      }
    }

    System.out.println(cnt);
  } // main

  static void year() {
    // Spring & Summer
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tree[i][j] != null) {
          Collections.sort(tree[i][j]);
          ArrayList<Integer> alive = new ArrayList<>();
          int die = 0;
          for (int k = 0; k < tree[i][j].size(); k++) {
            int age = tree[i][j].get(k);
            if (now[i][j] >= age) {
              now[i][j] -= age;
              alive.add(age + 1);
            } else {
              die += age / 2;
            }
          }
          tree[i][j] = alive;
          now[i][j] += die;
        }
      }
    }

    // Autumn
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tree[i][j] != null) {
          for (int k = 0; k < tree[i][j].size(); k++) {
            int age = tree[i][j].get(k);

            if (age % 5 == 0) {
              for (int l = 0; l < 8; l++) {
                int nx = i + dx[l];
                int ny = j + dy[l];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                tree[nx][ny].add(1);
              }
            }
          }
        }
      }
    }

    // Winter
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        now[i][j] += A[i][j];
      }
    }
  } // year

} // class
