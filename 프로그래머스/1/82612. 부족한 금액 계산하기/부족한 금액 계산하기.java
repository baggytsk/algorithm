class Solution {
    public long solution(int price, int money, int count) {
        long price_sum = 0;
        for(int i=1; i<=count; i++){
            price_sum += (long)(price * i);
        }
        
        return (price_sum <= money) ? 0 : price_sum - (long)money;
    }
}