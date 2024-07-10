class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
    
    for (String log : logs) {
        if (log.equals("../")) {
            if (!stack.isEmpty()) {
                stack.pop(); // Move to parent folder if possible
            }
        } else if (!log.equals("./")) {
            // It's a "x/" operation
            stack.push(log);
        }
        // If log is "./", do nothing
    }
    
    return stack.size();
    }
}