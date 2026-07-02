class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;

        while (true) {
            boolean[][] remove = new boolean[m][n];
            boolean found = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char now = map[i][j];

                    if (now == '-') {
                        continue;
                    }

                    if (now == map[i + 1][j]
                            && now == map[i][j + 1]
                            && now == map[i + 1][j + 1]) {

                        remove[i][j] = true;
                        remove[i + 1][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j + 1] = true;

                        found = true;
                    }
                }
            }

            if (!found) {
                break;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = '-';
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int write = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '-') {
                        map[write][j] = map[i][j];
                        write--;
                    }
                }

                for (int i = write; i >= 0; i--) {
                    map[i][j] = '-';
                }
            }
        }

        return answer;
    }
}