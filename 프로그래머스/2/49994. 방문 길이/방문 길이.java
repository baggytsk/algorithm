import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int[] cur = new int[]{0,0};
        
        for(char c : dirs.toCharArray()){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(cur[0]); sb1.append(cur[1]);
            sb2.append(cur[0]); sb2.append(cur[1]);
            if(c == 'R'){
                if(cur[0] == 5) continue;
                cur[0] += 1;
            } else if(c == 'L'){
                if(cur[0] == -5) continue;
                cur[0] -= 1;
            } else if(c == 'U'){
                if(cur[1] == 5) continue;
                cur[1] += 1;
            } else if(c == 'D'){
                if(cur[1] == -5) continue;
                cur[1] -= 1;
            }
            sb1.append(cur[0]); sb1.append(cur[1]);
            sb2.insert(0, cur[1]); sb2.insert(0, cur[0]);
            set.add(sb1.toString());
            set.add(sb2.toString());
        }
        
        return set.size()/2;
    }
}