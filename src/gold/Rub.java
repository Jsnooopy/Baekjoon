package lv2;

class Rub {
  public int solution(int[] money) {
    int[] dp = new int[money.length];

    dp[0] = money[0];
    dp[1] = dp[0];
    for(int i = 2; i < money.length - 1; i++){
      dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
    }

    int first = dp[money.length - 2];

    dp = new int[money.length];

    dp[1] = money[1];
    for(int i = 2; i < money.length; i++){
      dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
    }

    int second = dp[money.length - 1];

    int answer = Math.max(first, second);

    return answer;
  }
}