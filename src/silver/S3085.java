package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = s.charAt(j);
            }
        }

        int result = com(candy, N);
        System.out.println(result);
    }

    public static int com(char[][] arr, int N) {
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    char s = arr[i][j];
                    char ss = arr[i][j + 1];
                    arr[i][j] = ss;
                    arr[i][j + 1] = s;
                    max = Math.max(max, same(arr, N));

                    arr[i][j] = s;
                    arr[i][j + 1] = ss;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] != arr[j + 1][i]) {
                    char s = arr[j][i];
                    char ss = arr[j + 1][i];
                    arr[j][i] = ss;
                    arr[j + 1][i] = s;
                    max = Math.max(max, same(arr, N));

                    arr[j][i] = s;
                    arr[j + 1][i] = ss;
                }
            }
        }
        return max;
    }

    public static int same(char[][] arr, int N) {
        int cnt = 1;
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt += 1;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            cnt = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt += 1;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            cnt = 1;
        }
        return max;
    }
}
