import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>();
        map.put("zero", '0');
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
        
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9') sb.append(ch);
            else{
                temp += ch;
                if(map.containsKey(temp)) {
                    sb.append(map.get(temp));
                    temp = "";
                }
            }
        }
        int answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
}