package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class G17825 {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < 10 ; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }
        
        max = Integer.MIN_VALUE;
        for(int i = 0 ; i < 4; i++) {
            horses[i] = new horse(i);
        }
        
        dfs(0);
        System.out.println(max);
    }
    static int[][] lines = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
            {10, 13, 16, 19},
            {30, 28, 27, 26},
            {20, 22, 24, 25, 30, 35, 40}
    };
    static int[] dices = new int[10];
    
    static int max;
    static int[] moves = new int[10];
    static void dfs(int pos) {
        
        if(pos == 10) {
            
            for(int i = 0 ; i < 4 ; i++) {
                horses[i].l = 0;
                horses[i].pos = 0;
            }
            int score = 0;
            int h_l=0, h_pos;
            for(int i = 0 ; i < 10; i++) {
                boolean ok = horses[moves[i]].move(dices[i]);
                if(ok) {
                    h_l = horses[moves[i]].l;
                    h_pos = horses[moves[i]].pos;
                    if(h_l == 3 && h_pos == 7)
                        continue;
                    else
                        score += lines[h_l][h_pos];
                }else
                    return ;
            }
            if(max < score) {
                max = score;
            }
            return;
        }
        
        for(int h = 0 ; h < 4 ; h++) {
            moves[pos] = h;
            dfs(pos+1);
        }
    }
    
    static horse[] horses = new horse[4];
    static class horse {
        int l ;
        int pos ;
        int num;
        
        public horse(int num) {
            this.num = num;
            this.l = 0;
            this.pos = 0;
        }
        
        public boolean move(int m) {
            int next = pos + m;
            int nl = l;
            if(l == 0) {
                if(next == 5) {
                    nl = 1;
                    next = 0;
                }else if(next == 10) {
                    nl = 3;
                    next = 0;
                }else if(next == 15) {
                    nl = 2;
                    next = 0;
                }else if(next == 20) {
                    nl = 3;
                    next = 6;
                }else if(next > 20) {
                    nl = 3;
                    next = 7;
                }
            }else if(l == 1) {
                if(next>3) {
                    nl = 3;
                    next--;
                    if(next > 6) {
                        next = 7;
                    }
                }
            }else if(l==2) {
                if(next>3) {
                    nl = 3;
                    next--;
                    if(next > 6) {
                        next = 7;
                    }
                }
            }else if(l == 3) {
                if(next>6) {
                    next = 7;
                }
            }
            
            if(nl == 3 && next == 7) {
                l = nl;
                pos = next;
                return true;
            }
            
            for(int i = 0 ; i < 4 ; i++) {
                if(num == i)
                    continue;
                if(horses[i].l == 3 && horses[i].pos == 7)
                    continue;
                if(horses[i].l == 0 && horses[i].pos == 0)
                    continue;
                
                if(horses[i].l == nl && horses[i].pos == next ) {
                    return false;
                }
            }
            l = nl;
            pos = next;
            return true;
        }
    }
}
 