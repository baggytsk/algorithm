class Solution {
    public String solution(int a, int b) {
        String[] dateName = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int date = 0;
        for(int i=1; i<a; i++){
            if(i==2) date += 29;
            else if(i==4 || i==6 || i==9 || i==11) date += 30;
            else date += 31;
        }
        
        date += b;
    
        int index = date%7;
        return dateName[index];
    }
}