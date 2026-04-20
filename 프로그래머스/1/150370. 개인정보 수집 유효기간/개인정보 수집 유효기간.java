import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> term = new HashMap<>();
        
        int ty = Integer.parseInt(today.split("\\.")[0]);
        int tm = Integer.parseInt(today.split("\\.")[1]);
        int td = Integer.parseInt(today.split("\\.")[2]);
        
        StringTokenizer st;
        for(String s : terms){
            st = new StringTokenizer(s);
            term.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= privacies.length; i++){
            String s = privacies[i - 1];
            st = new StringTokenizer(s);
            String ps = st.nextToken();
            int py = Integer.parseInt(ps.split("\\.")[0]);
            int pm = Integer.parseInt(ps.split("\\.")[1]);
            int pd = Integer.parseInt(ps.split("\\.")[2]);
            
            int m = term.get(st.nextToken());
            if(pd == 1) {
                pd = 28;
                pm--;
            }
            else pd--;
            
            if(pm + m > 12){
                pm += m;
                while(pm > 12){
                    py++;
                    pm -= 12;
                }
            }
            else pm += m;
            
            if (py < ty) list.add(i);
            else if(py == ty){
                if(pm < tm) list.add(i);
                else if(pm == tm){
                    if(pd < td) list.add(i);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}