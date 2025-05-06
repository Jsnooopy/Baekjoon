package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1259 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String num = br.readLine();
            boolean result = true;

            if (num.equals("0")){
                break;
            }

            for (int i = 0; i < num.length() / 2; i++) {
                if(num.charAt(i) != num.charAt(num.length() - 1 - i)){
                    result = false;
                    break;
                }
            }

            if(result) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        br.close();
    }
}
