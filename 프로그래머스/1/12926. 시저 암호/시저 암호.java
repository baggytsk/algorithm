class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == ' ') sb.append(c);
            else if(c-'A' < 26){
                sb.append((char)('A'+ (c-'A'+n)%26 ));
            } else{
                sb.append((char)('a'+ (c-'a'+n)%26 ));
            }
        }
        
        return sb.toString();
    }
}