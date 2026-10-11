import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) 
            return cities.length*5;
        
        List<String> list = new ArrayList<>();
        int time = 0;
        
        for(String city : cities){
            city = city.toLowerCase();
            
            if(list.contains(city)){
                list.remove(city);
                list.add(city);
                time += 1;
            } else{
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city);
                time += 5;
            }
        }
            
        return time;
    }
}