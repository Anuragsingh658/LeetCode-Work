class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            return calculateMaxScore(s, 'a', 'b', x, y);
        } else {
            return calculateMaxScore(s, 'b', 'a', y, x);
        }
    }

    private int calculateMaxScore(String s, char first, char second, int firstScore, int secondScore) {
        int totalScore = 0;
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.append(c);
            int length = stack.length();
            if (length >= 2 && stack.charAt(length - 2) == first && stack.charAt(length - 1) == second) {
                stack.delete(stack.length() - 2, stack.length());
                totalScore += firstScore;
            }
        }
        String remainingString = stack.toString();
        stack.setLength(0);  // reset the stack

        for (char c : remainingString.toCharArray()) {
            stack.append(c);
            int length = stack.length();
            if (length >= 2 && stack.charAt(length - 2) == second && stack.charAt(length - 1) == first) {
                stack.delete(stack.length() - 2, stack.length());
                totalScore += secondScore;
            }
        }

        return totalScore;
    }
}