class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            int n1 = arr1[i], n2 = arr2[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(n1 % 2 == 1 || n2 % 2 == 1) sb.insert(0, "#");
                else sb.insert(0, " ");
                n1 /= 2; n2 /= 2;
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    
}