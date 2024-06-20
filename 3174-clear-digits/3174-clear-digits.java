class Solution {
    public String clearDigits(String s) {
         StringBuilder sb = new StringBuilder(s);
        boolean foundDigit;

        do {
            foundDigit = false;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    foundDigit = true;
                    // Find the closest non-digit character to the left
                    int leftIndex = i - 1;
                    while (leftIndex >= 0 && Character.isDigit(sb.charAt(leftIndex))) {
                        leftIndex--;
                    }
                    if (leftIndex >= 0) {
                        sb.deleteCharAt(leftIndex); // Remove the non-digit character
                        i--; // Adjust i as the string length is reduced by 1
                    }
                    sb.deleteCharAt(i); // Remove the digit
                    break; // Restart from the beginning
                }
            }
        } while (foundDigit);

        return sb.toString();
    }
}