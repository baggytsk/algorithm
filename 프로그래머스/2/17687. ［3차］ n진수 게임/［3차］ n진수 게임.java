class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder allText = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        while (allText.length() <= t * m) {
            allText.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        
        for (int i = 0; i < t; i++) {
            answer.append(allText.charAt(p - 1 + (i * m)));
        }
        
        return answer.toString();
    }
}