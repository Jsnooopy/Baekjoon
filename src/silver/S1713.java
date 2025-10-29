package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1713 {

  static class Stu{
    int s, c, r;

    public Stu(int s, int c, int r) {
      this.s = s;
      this.c = c;
      this.r = r;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int recommend = Integer.parseInt(br.readLine());
    ArrayList<Stu> pic = new ArrayList<>();

    int cnt  = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < recommend; i++) {
      int student = Integer.parseInt(st.nextToken());
      cnt++;

      boolean check = false;

      if (pic.isEmpty()) {
        pic.add(new Stu(student, cnt, 1));
      } else if (pic.size() < N) {
        for (Stu stu : pic) {
          if(stu.s == student){
            stu.r++;
            check = true;
          }
        }
        if (!check) {
          pic.add(new Stu(student, cnt, 1));
        }
      } else {
        for (Stu stu : pic) {
          if(stu.s == student){
            stu.r++;
            check = true;
          }
        }
        if (!check) {
          int min = 1001;
          ArrayList<Integer> list = new ArrayList<>();

          for (Stu stu : pic) {
            min = Math.min(min, stu.r);
          }
          for (Stu stu : pic) {
            if (stu.r == min) list.add(stu.s);
          }

          if (list.size() == 1) {
            for (int j = 0; j < pic.size(); j++) {
              if (pic.get(j).s == list.get(0)) {
                pic.remove(j);
                pic.add(new Stu(student, cnt, 1));
              }
            }
          } else {
            int old = 1001;
            for (int j = 0; j < list.size(); j++) {
              for (int k = 0; k < pic.size(); k++) {
                if (list.get(j) == pic.get(k).s) {
                  old = Math.min(old, pic.get(k).c);
                }
              }
            }
            for (int j = 0; j < pic.size(); j++) {
              if (pic.get(j).c == old) {
                pic.remove(j);
                pic.add(new Stu(student, cnt, 1));
              }
            }
          }
        }
      }
    }

    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < pic.size(); i++) {
      result.add(pic.get(i).s);
    }
    Collections.sort(result);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.size(); i++) {
      sb.append(result.get(i)).append(" ");
    }

    System.out.println(sb);
  }

}
