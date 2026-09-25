import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sum = new HashSet<>();
        int len = elements.length;
        
        for(int i=0; i<len; i++){
            int num = 0;
            for(int j=0; j<len; j++){
                num += elements[(i+j)%len];
                sum.add(num);
            }
        }
        
        return sum.size();
    }
}