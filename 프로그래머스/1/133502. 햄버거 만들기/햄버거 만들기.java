class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] st = new int[ingredient.length];
        int idx = 0;
        
        for (int item : ingredient) {
            st[idx++] = item;
            
            if (idx >= 4 && 
                st[idx - 1] == 1 && 
                st[idx - 3] == 2 && 
                st[idx - 2] == 3 && 
                st[idx - 4] == 1) {
                idx -= 4;
                answer++;
            }
        }
        
        return answer;
    }
}