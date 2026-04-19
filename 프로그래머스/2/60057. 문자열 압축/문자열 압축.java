import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        int minLen = len;
        StringBuffer sb;
        
        for(int i=1; i<=len/2; i++){ 
            sb = new StringBuffer();
            
            int idx=0;
            while(idx<len){
                String str = s.substring(idx,idx+i);
                
                int cnt =1;
                while(idx+cnt*i < len &&
                          s.substring(idx+cnt*i).indexOf(str) == 0) cnt++;
            
                sb.append(cnt !=1 ?cnt+str : str);
                idx += cnt*i;
                
                if(idx+i>len) {
                    sb.append(s.substring(idx));
                    break;
                } 
            }
            minLen = Math.min(minLen, sb.toString().length());
        }
        return minLen;
    }
}