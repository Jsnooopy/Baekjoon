package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G11444 {

    private static long[][] A = new long[2][2];
    private static long[][] C = new long[2][2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        A = new long[][] {{1, 1}, {1, 0}};

        C = DQ(n);
        
        System.out.println(C[0][1]);
    }

    public static long[][] mul(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        
        for (int i = 0; i < 2; i++) {
            C[i] = new long[2];
            
            for (int j = 0; j < 2; j++) {
                for (int x = 0; x < 2; x++)
                    C[i][j] += A[i][x] * B[x][j];
                C[i][j] = C[i][j] % 1000000007;
            }
        }
        
        return C;
    }

    public static long[][] DQ(long n) {
        if (n == 1) return A;

        long[][] res = DQ(n / 2);

        if (n % 2 == 0) return mul(res, res);
        else return mul(A, mul(res, res));
    }
}
