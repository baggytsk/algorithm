class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        answer = answer.replaceAll("\\.{2,}", ".");
        
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        StringBuilder sb = new StringBuilder(answer);
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        answer = sb.toString();
        
        return answer;
    }
}