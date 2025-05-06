package bronze;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        double[] arr = new double[N];
        double sum = 0;

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        double max = arr[0];
        for (int j = 0; j < N; j++){
            if(arr[j] > max){
                max = arr[j];
            }
        }

        for (int k = 0; k < N; k++){
            arr[k] = arr[k] / max * 100;
            sum += arr[k];
        }

        System.out.println(sum/(double)N);

    }
}
