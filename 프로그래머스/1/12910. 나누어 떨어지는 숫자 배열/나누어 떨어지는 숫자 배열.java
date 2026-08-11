import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int n : arr){
            if(n % divisor == 0) list.add(n);
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}