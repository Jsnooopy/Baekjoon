package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G20164 {

  static int max, min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String s = br.readLine();

    max = 0;
    min = Integer.MAX_VALUE;
    oper(s, 0);

    sb.append(min).append(" ").append(max);
    System.out.println(sb);
  }

  static void oper(String s, int cnt) {
    if (s.length() == 1) {
      if(s.charAt(0) % 2 == 1) cnt++;
      max = Math.max(max, cnt);
      min = Math.min(min, cnt);
    }
    else if (s.length() == 2) {
      for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i) % 2 == 1) cnt++;
      }

      int temp = Integer.parseInt(String.valueOf(s.charAt(0))) + Integer.parseInt(String.valueOf(s.charAt(1)));
      String t = String.valueOf(temp);

      oper(t, cnt);
    }
    else {
      for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i) % 2 == 1) cnt++;
      }

      for (int j = 1; j < s.length() - 1; j++) {
        for (int k = j + 1; k < s.length(); k++) {
          String t = getString(s, j, k);

          oper(t, cnt);
        }
      }
    }
  }

  private static String getString(String s, int j, int k) {
    String sub1 = s.substring(0, j);
    String sub2 = s.substring(j, k);
    String sub3 = s.substring(k);

    while (sub1.charAt(0) == 0) {
      sub1 = sub1.substring(1);
    }
    while (sub2.charAt(0) == 0) {
      sub2 = sub2.substring(1);
    }
    while (sub3.charAt(0) == 0) {
      sub3 = sub3.substring(1);
    }

    int temp = Integer.parseInt(sub1) + Integer.parseInt(sub2) + Integer.parseInt(sub3);
    String t = String.valueOf(temp);
    return t;
  }

}
