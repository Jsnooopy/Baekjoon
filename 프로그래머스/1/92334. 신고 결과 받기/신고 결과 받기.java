import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> idxMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            idxMap.put(id_list[i], i);
        }
        
        StringTokenizer st;
        for(int i = 0; i < report.length; i++){
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            
            if(!map.containsKey(to)){
                map.put(to, new HashSet<>());
            }
            
            map.get(to).add(from);
        }
        
        int[] answer = new int[id_list.length];
        
        for(String user : map.keySet()){
            if(map.get(user).size() >= k){
                for(String reporter : map.get(user)){
                    answer[idxMap.get(reporter)]++;
                }
            }
        }
        
        return answer;
    }
}