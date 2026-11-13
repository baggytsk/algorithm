class Solution {
    public String solution(String X, String Y) {
        int[] checkX = new int[10];
        int[] count = new int[10];
        
        for(char c : X.toCharArray()){
            checkX[c-'0']++;
        }
        
        for(char c : Y.toCharArray()){
            int n = c-'0';
            if(checkX[n] == 0) continue;
            checkX[n]--;
            count[n]++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=9; i>=0; i--){
            if(i==0 && count[i]>0 && answer.isEmpty()) {
                answer.append(0);
                break;
            }
            for(int j=0; j<count[i]; j++)
                answer.append(i);
        }
        
        return answer.isEmpty() ? "-1" : answer.toString();
    }
}