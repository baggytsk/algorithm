class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean change = true;
        int same = 0, dif = 0;
        char x = ' ';
        
        for(char c : s.toCharArray()){
            if(change) {
                x = c; same++; change = false; continue;
            }
            if(x == c){
                same++;
            } else{
                dif++;
            }
            if(same == dif) {
                same = 0; dif = 0; answer++; change = true;
            }
        }
        
        return (same == 0 && dif == 0) ? answer : answer+1;
    }
}