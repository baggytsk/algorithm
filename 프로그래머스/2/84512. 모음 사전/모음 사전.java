import java.util.*;

class Solution {
    String[] c = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
    
    void dfs(String cur, int d){
        if(d > 5) return;
        list.add(cur);
        
        for(int i=0; i<5; i++){
            dfs(cur+c[i], d+1);
        }
    }
}