import java.util.*;

class Solution {
    long[][] dp;
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] link : links){
            int u = link[0];
            int v = link[1];
            
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        
        dp = new long[sales.length+1][2];
        dfs(1, graph, sales);
        
        return (int)Math.min(dp[1][0], dp[1][1]);
    }
    
    void dfs(int node, Map<Integer, List<Integer>> g, int[] sales){
        List<Integer> c = g.getOrDefault(node, Collections.emptyList());
        if(c.isEmpty()){
            dp[node][1] = (long)sales[node - 1];
            dp[node][0] = 0;
            return;
        }
        
        long base = 0;
        long extra = Long.MAX_VALUE;
        boolean hasAttend = false;
        
        for(int child : c){
            dfs(child, g, sales);
            base += Math.min(dp[child][0], dp[child][1]);
            if(dp[child][1] <= dp[child][0]) hasAttend = true;
            extra = Math.min(extra, dp[child][1] - dp[child][0]);
        }
        
        dp[node][1] += (long)sales[node - 1] + base;
        dp[node][0] += hasAttend ? base : base + extra;
    }
}