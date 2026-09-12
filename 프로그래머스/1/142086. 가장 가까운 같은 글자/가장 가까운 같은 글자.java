class Solution {
    public int[] solution(String s) {
        int[] pos = new int[26];
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            int word = s.charAt(i)-'a';
            if(pos[word] == 0) answer[i] = -1;
            else answer[i] = i+1 - pos[word];
            pos[word] = i+1;
        }
        
        return answer;
    }
}