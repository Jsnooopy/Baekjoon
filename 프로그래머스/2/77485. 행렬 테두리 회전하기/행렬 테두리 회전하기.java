class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int number = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = number++;
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;

            int temp = map[x1][y1];
            int min = temp;

            // 왼쪽 열 위로 이동
            for (int i = x1; i < x2; i++) {
                map[i][y1] = map[i + 1][y1];
                min = Math.min(min, map[i][y1]);
            }

            // 아래 행 왼쪽으로 이동
            for (int j = y1; j < y2; j++) {
                map[x2][j] = map[x2][j + 1];
                min = Math.min(min, map[x2][j]);
            }

            // 오른쪽 열 아래로 이동
            for (int i = x2; i > x1; i--) {
                map[i][y2] = map[i - 1][y2];
                min = Math.min(min, map[i][y2]);
            }

            // 위 행 오른쪽으로 이동
            for (int j = y2; j > y1 + 1; j--) {
                map[x1][j] = map[x1][j - 1];
                min = Math.min(min, map[x1][j]);
            }

            map[x1][y1 + 1] = temp;

            answer[q] = min;
        }

        return answer;
    }
}