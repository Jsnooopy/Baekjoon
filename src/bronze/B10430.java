package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int C = Integer.parseInt(split[2]);

        sb.append((A + B) % C).append("\n");
        sb.append(((A % C) + (B % C)) % C).append("\n");
        sb.append((A * B) % C).append("\n");
        sb.append(((A % C) * (B % C)) % C).append("\n");

        System.out.println(sb);
    }
}
