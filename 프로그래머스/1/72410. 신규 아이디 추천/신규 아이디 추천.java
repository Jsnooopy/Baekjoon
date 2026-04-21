class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < new_id.length(); i++){
            char ch = Character.toLowerCase(new_id.charAt(i));
            
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.'){
                
                if(ch == '.'){
                    if(sb.length() == 0 || sb.charAt(sb.length() - 1) == '.') continue;
                }
                
                sb.append(ch);
            }
        }
        
        if(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        
        if(sb.length() == 0) sb.append('a');
        
        if(sb.length() >= 16) sb.setLength(15);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        
        while(sb.length() < 3){
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}