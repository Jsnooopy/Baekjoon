package bronze;

import java.io.*;
import java.util.*;

public class P4153{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int big = 0;
        int end = 0;

        while(true){
            String str = br.readLine();
            String[] splitLine = str.split(" ");
            int[] lineInt = new int[3];
            for(int i =0; i < 3; i++){
                int temp = Integer.parseInt(splitLine[i]);
                lineInt[i] = temp * temp;
                if(lineInt[0] == 0){
                    end++;
                }
            }
            Arrays.sort(lineInt);
            if(end == 3){
                break;
            }else{
                if(lineInt[2] == lineInt[0] + lineInt[1]){
                    System.out.println("right");
                }else{
                    System.out.println("wrong");
                }
                end = 0;
            }
        }
    }
}