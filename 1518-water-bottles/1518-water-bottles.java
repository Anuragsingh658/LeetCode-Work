class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottlesDrunk = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            totalBottlesDrunk += newBottles;
            emptyBottles = emptyBottles % numExchange + newBottles;
        }

        return totalBottlesDrunk;
    }
}