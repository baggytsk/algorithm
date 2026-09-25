import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            if(i == 0) wordSet.add(words[i]);
            else if(wordSet.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) || words[i].length() < 2){
                return new int[]{i%n+1, i/n+1};
            } 
            else wordSet.add(words[i]);
        }

        return new int[]{0,0};
    }
}