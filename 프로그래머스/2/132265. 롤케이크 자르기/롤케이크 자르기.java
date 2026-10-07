import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : topping) map.put(t, map.getOrDefault(t, 0)+1);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int t : topping){
            set.add(t);
            if(map.get(t) == 1) map.remove(t);
            else map.put(t, map.get(t)-1);
            if(set.size() == map.keySet().size()) count++;
        }
        
        return count;
    }
}