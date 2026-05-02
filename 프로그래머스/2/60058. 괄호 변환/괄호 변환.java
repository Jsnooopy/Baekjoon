class Solution {
    public String solution(String u) {
        if(u.length()==0) return "";
        int index = findIndex(u);
        String v = u.substring(index);
        u = u.substring(0,index);
        if(isValid(u)){
            return u+solution(v);
        }
        else{
            u = u.substring(1,u.length()-1);
            return "("+solution(v)+")"+reverse(u);
        }
    }
    public int findIndex(String u){
        int index=0, open=0, close=0, length=u.length();
        while(index<length){
            if(u.charAt(index)=='(') open++;
            else close++;
            index++;
            if(open==close) break;
        }
        return index;
    }
    public boolean isValid(String u){
        String temp = new String(u);
        int length = temp.length();
        while(length!=0){
            String excluded = String.join("",temp.split("\\(\\)"));
            if(excluded.length() ==length) return false;
            temp = excluded;
            length = temp.length();
        }
        return true;
    }
    public String reverse(String u){
        u = u.replace("(","a");
        u  = u.replace(")","(");
        return u.replace("a",")");
    }
} 
