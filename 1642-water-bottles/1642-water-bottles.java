class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;  // already full bottles to drink
        int empty = numBottles;
        
        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            drank += newFull;
            empty = newFull + (empty % numExchange);
        }
        
        return drank;
        
    }
}