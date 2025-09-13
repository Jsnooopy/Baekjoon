package silver;

import java.util.Scanner;

public class S1541 {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine(); // 식 입력 받기
        String[] expressions = expression.split("-"); // 최소값을 구하기 위해서는 -의 뒤에 값이 커야하기에 - 기준으로 나누기

        for (int i = 0; i < expressions.length; i++) {
            int sum = mySum(expressions[i]); // - 뒤에 값을 합
            if (i == 0) { // 모두 양수이기 떄문에 맨 앞의 수는 무조건 더한다.
                answer = answer + sum;
            } else { // 그 외에 수는 뺀다.
                answer = answer - sum;
            }
        }

        System.out.println(answer);
    }

    // -의 뒤의 수를 최댓값으로 만들기 위해 앞의 -와 뒤의 -사이에 괄호를 넣어 그 최댓값을 계산하는 메서드
    private static int mySum(String expression) {
        int sum = 0;
        String[] numbers = expression.split("\\+"); // split 메서드를 사용할 때 regex에 "+"를 넣으면 에러 발생하기 떄문에 "\\+" 혹은 "[+]" 넣기
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}