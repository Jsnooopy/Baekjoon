package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12891 {
    static int[] num = new int[4];
    static int[] part = new int[4];
    static int checkcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] DNA = br.readLine().toCharArray();

        checkcnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            if (num[i] == 0) {
                checkcnt++;
            }
        }

        int resultcnt = 0;
        for (int i = 0; i < P; i++) {
            add(DNA[i]);
        }

        if (checkcnt == 4) {
            resultcnt++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(DNA[i]);
            remove(DNA[j]);

            if (checkcnt == 4) {
                resultcnt++;
            }
        }

        System.out.println(resultcnt);
    }

    static void add(char value) {
        switch (value) {
            case 'A' :
                part[0]++;
                if (part[0] == num[0]) {
                    checkcnt++;
                }
                break;

            case 'C':
                part[1]++;
                if (part[1] == num[1]) {
                    checkcnt++;
                }
                break;

            case 'G':
                part[2]++;
                if (part[2] == num[2]) {
                    checkcnt++;
                }
                break;

            case 'T':
                part[3]++;
                if (part[3] == num[3]) {
                    checkcnt++;
                }
                break;
        }
    }

    static void remove(char value) {
        switch (value) {
            case 'A' :
                if (part[0] == num[0]) {
                    checkcnt--;
                }
                part[0]--;
                break;

            case 'C':
                if (part[1] == num[1]) {
                    checkcnt--;
                }
                part[1]--;
                break;

            case 'G':
                if (part[2] == num[2]) {
                    checkcnt--;
                }
                part[2]--;
                break;

            case 'T':
                if (part[3] == num[3]) {
                    checkcnt--;
                }
                part[3]--;
                break;
        }
    }
}
