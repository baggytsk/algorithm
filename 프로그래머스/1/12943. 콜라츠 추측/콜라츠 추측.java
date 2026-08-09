class Solution {
    public int solution(int num) {
        int count = 0;
        if(num == 1) return 0;
        
        long newNum = (long)num;
            
        while(newNum != 1 && count < 500){
            if(newNum % 2 == 0) newNum /= 2;
            else newNum = newNum*3+1;
            count++;
        }
        
        return (count == 500) ? -1 : count;
    }
}