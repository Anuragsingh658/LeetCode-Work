class Solution {
    public int findWinningPlayer(int[] skills, int k) {
       int n = skills.length;
        Queue<Integer> queue = new LinkedList<>();

        // Add all players to the queue
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int currentWinner = queue.poll();
        int winCount = 0;

        while (winCount < k && winCount < n - 1) {
            int nextChallenger = queue.poll();
            if (skills[currentWinner] > skills[nextChallenger]) {
                winCount++;
                queue.add(nextChallenger);
            } else {
                winCount = 1;
                queue.add(currentWinner);
                currentWinner = nextChallenger;
            }
        }

        return currentWinner;  
    }
}