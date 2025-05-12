package silver;

import java.io.*;
import java.util.*;

public class P1018 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();

        }

        int answer = Integer.MAX_VALUE;
        // 가능한 시작점의 위치
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                // 8x8방향 탐색
                char std1 = 'B';
                char std2 = 'W';
                int sum1 = 0;
                int sum2 = 0;

                for(int n = 0; n < 8; n++) {
                    for(int m = 0; m < 8; m++) {
                        // 시작점과 같은 말일 때
                        if(n % 2 == 1 && m % 2 == 1 ||
                                n % 2 == 0 && m % 2 == 0) {
                            if(arr[i+n][j+m] != std1) {
                                sum1++;
                            }
                            if(arr[i+n][j+m] != std2) {
                                sum2++;
                            }
                        }
                        // 시작점과 같은 말이 아닐 때
                        else if(n % 2 == 1 && m % 2 == 0 ||
                                n % 2 == 0 && m % 2 == 1) {
                            if(arr[i+n][j+m] == std1) {
                                sum1++;
                            }
                            if(arr[i+n][j+m] == std2) {
                                sum2++;
                            }
                        }
                    }
                }
                answer = Math.min(answer, Math.min(sum1, sum2));
            }
        }
        System.out.println(answer);
    }
}