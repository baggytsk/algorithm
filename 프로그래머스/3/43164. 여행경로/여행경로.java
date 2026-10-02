import java.util.*;

class Solution {
    boolean[] used;
    List<String> path = new ArrayList<>();
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        used = new boolean[tickets.length];
        path.add("ICN");
        dfs(tickets, "ICN");
        return answer;
    }
    
    boolean dfs(String[][] tickets, String cur){
        if(path.size() == tickets.length+1){
            answer = path.toArray(new String[0]);
            return true;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(used[i] || !tickets[i][0].equals(cur)) continue;
            used[i] = true;
            path.add(tickets[i][1]);
            if (dfs(tickets, tickets[i][1])) return true;
            path.remove(path.size()-1);
            used[i] = false;
        }
        return false;
    }
    
    
}