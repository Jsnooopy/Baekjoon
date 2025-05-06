package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int T = Integer.parseInt(s2[0]);
        int P = Integer.parseInt(s2[1]);

        int[] T_shirts = new int[6];
        for (int i = 0; i < 6; i++) {
            T_shirts[i] = Integer.parseInt(s1[i]);
        }

        int Tshirts = 0;
        for (int i = 0; i < 6; i++) {
            if (T_shirts[i] > 0) {
                Tshirts += T_shirts[i] / T;
                if (T_shirts[i] % T != 0) {
                    Tshirts += 1;
                }
            }
        }

        int penBundles = N / P;
        int remainingPens = N % P;

        System.out.println(Tshirts);
        System.out.println(penBundles + " " + remainingPens);

    }
}