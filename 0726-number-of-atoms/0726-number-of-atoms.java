class Solution {
    public String countOfAtoms(String formula) {
         int n = formula.length();
        Map<String, Integer> countMap = new HashMap<>();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());

        for (int i = 0; i < n; ) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, multiplicity = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String key : top.keySet()) {
                    int count = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + count * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = (i > iStart) ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {
            countMap.put(entry.getKey(), entry.getValue());
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(countMap);
        StringBuilder result = new StringBuilder();
        
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        
        return result.toString();
    }
}