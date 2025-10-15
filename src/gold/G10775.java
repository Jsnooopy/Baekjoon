package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G10775 {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int G = Integer.parseInt(br.readLine());
    int P = Integer.parseInt(br.readLine());

    parent = new int[G + 1];
    for (int i = 1; i <= G; i++) {
      parent[i] = i;
    }

    int cnt = 0;
    for (int i = 0; i < P; i++) {
      int g = Integer.parseInt(br.readLine());

      int can = find(g);

      if(can == 0) break;

      cnt++;
      union(can, can - 1);
    }

    System.out.println(cnt);
  } // main

  static void union(int num1, int num2) {
    num1 = find(num1);
    num2 = find(num2);

    parent[num1] = num2;
  } // union

  static int find(int num) {
    if(num == parent[num]) return num;
    else return parent[num] = find(parent[num]);
  } // find

} // class
