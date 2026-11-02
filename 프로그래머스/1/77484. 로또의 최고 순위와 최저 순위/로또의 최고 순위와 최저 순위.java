import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int same = 0, no = 0;
        List<Integer> list = Arrays.stream(win_nums)
                           .boxed()
                           .collect(Collectors.toList());

        for(int l : lottos){
            if(l==0) no++;
            else if(list.contains(l)) same++;
        }
        
        int maxRank = Math.min(7 - (same + no), 6);
        int minRank = Math.min(7 - same, 6);
        
        return new int[]{maxRank, minRank};
    }
}