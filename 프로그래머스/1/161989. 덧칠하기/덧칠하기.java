class Solution {
    public int solution(int n, int m, int[] section) {
        int loc = section[0];
        int count = 0;
        
        for(int s : section){
            if(s < loc) continue;
            if(loc < s) loc = s;
            loc += m;
            count ++;
            if(loc > n) break;
        }
        
        return count;
    }
}