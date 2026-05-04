import java.util.*;

class Solution {

    static int N, M;
    static int[][] users;
    static int[] emoticons;

    static int[] sale;
    static int[] discount = {10, 20, 30, 40};

    static int maxPlus = 0;
    static int maxMoney = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        N = users.length;
        M = emoticons.length;

        sale = new int[M];

        dfs(0);

        return new int[]{maxPlus, maxMoney};
    }

    static void dfs(int depth) {
        if (depth == M) {
            check();
            return;
        }

        for (int i = 0; i < 4; i++) {
            sale[depth] = discount[i];
            dfs(depth + 1);
        }
    }

    static void check() {
        int plus = 0;
        int money = 0;

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j < M; j++) {
                if (sale[j] >= users[i][0]) {
                    sum += emoticons[j] * (100 - sale[j]) / 100;
                }
            }

            if (sum >= users[i][1]) {
                plus++;
            } else {
                money += sum;
            }
        }

        if (plus > maxPlus) {
            maxPlus = plus;
            maxMoney = money;
        } else if (plus == maxPlus && money > maxMoney) {
            maxMoney = money;
        }
    }
}