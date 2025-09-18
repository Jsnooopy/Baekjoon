package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class G2580{
	
	static class Pair{
	    int y;
	    int x;

	    public Pair(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	}
	
    static int[][] sudoku = new int[9][9];
    static ArrayList<Pair> req = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) req.add(new Pair(i,j));
            }
        }

        dfs(0);
    }

    static boolean check(int y, int x, int num){
        int y_start =  (y / 3) * 3;
        int x_start = (x / 3) * 3;

        for(int i = 0; i < 9; i++){
            if(sudoku[y][i] == num) return false;

            if(sudoku[i][x] == num) return false;

            if(sudoku[y_start + i / 3][x_start + i % 3] == num) return false;
        }
        return true;
    }

    static void dfs(int cnt){
        if(cnt == req.size()){
        	StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(sudoku[i][j]);
                    sb.append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        int y = req.get(cnt).y;
        int x = req.get(cnt).x;
        
        for(int j = 1; j <= 9; j++){
            if(check(y, x, j)){
                sudoku[y][x] = j;
                dfs(cnt + 1);
                sudoku[y][x] = 0;
            }
        }
    }

}