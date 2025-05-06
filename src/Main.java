// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
        }

        scanner.close();

        int max = array[0];
        int min = array[0];

        for(int j = 0; j < N; j++){
            if(array[j] < min){
                min = array[j];
            }
            if(array[j] > max){
                max = array[j];
            }
        }

        System.out.println(min + " " + max);



    }
}