import java.lang.Math;
class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.insert(0, n%3);
            n/=3;
        }
        
        sb = sb.reverse();
        int answer = 0;
        
        for(int i=0; i<sb.length(); i++){
            answer += (sb.charAt(i)-'0') * (int)Math.pow(3, sb.length()-i-1);
        }
        
        return answer;
    }
}