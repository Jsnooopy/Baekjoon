package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G2342 {

  static ArrayList<Integer> list;
  static int[][][] dp;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    list = new ArrayList<Integer>();
    while (true) {
      int num = Integer.parseInt(st.nextToken());
      if(num == 0) break;
      list.add(num);
    }

    N = list.size();
    dp = new int[N + 1][5][5];

    System.out.println(ddr(0, 0, 0));
    br.close();
  }

  static int ddr(int step, int left, int right) {
    if (step == N) return 0;

    if (dp[step][left][right] != 0) return dp[step][left][right];

    int leftScore = score(left, list.get(step)) + ddr(step + 1, list.get(step), right);
    int rightScore = score(right, list.get(step)) + ddr(step + 1, left, list.get(step));

    return dp[step][left][right] = Math.min(leftScore, rightScore);
  } // main

  static int score(int from, int to){
    if(from == to) return 1;

    else if(from == 0) return 2;

    else if(Math.abs(from - to) == 2) return 4;

    else return 3;
  } // score

} // class
