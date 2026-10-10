class Solution {
    public int solution(int[] wallet, int[] bill) {
        int longWallet = Math.max(wallet[0], wallet[1]);
        int shortWallet = Math.min(wallet[0], wallet[1]);
        int longBill = Math.max(bill[0], bill[1]);
        int shortBill = Math.min(bill[0], bill[1]);
        int count = 0;
        
        while(!(longWallet >= longBill && shortWallet >= shortBill)){
            longBill /= 2;
            if(longBill < shortBill) {
                int temp = longBill;
                longBill = shortBill;
                shortBill = temp;
            }
            count++;
        }
              
        return count;
    }
}