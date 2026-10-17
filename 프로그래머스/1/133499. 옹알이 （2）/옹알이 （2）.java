class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            if (b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) {
                continue;
            }
            
            for (String p : possible) {
                b = b.replace(p, " ");
            }
            
            if (b.trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}