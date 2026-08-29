class Solution {
    public int solution(int n) {
        int targetBitCount = Integer.bitCount(n);
        int nextNumber = n + 1;
        
        while(Integer.bitCount(nextNumber) != targetBitCount) {
            nextNumber++;
        }
        
        return nextNumber;
    }
}