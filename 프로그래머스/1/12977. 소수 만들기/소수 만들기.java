class Solution {
    int count = 0;
    boolean[] visited;
    
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        dfs(0, 0, 0, nums);
        return count;
    }
    
    boolean isPrime(int num){
        if (num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    
    void dfs(int start, int sum, int d, int[] nums){
        if(d == 3){
            if(isPrime(sum)) count++;
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(i+1, sum + nums[i], d+1, nums);
            visited[i] = false;
        }
    }
}