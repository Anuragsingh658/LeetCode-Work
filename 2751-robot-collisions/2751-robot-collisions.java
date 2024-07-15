class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices by positions
        Arrays.sort(indices, Comparator.comparingInt(i -> positions[i]));
        
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);
        
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty()) {
                    int rightIdx = stack.peek();
                    if (healths[rightIdx] < healths[idx]) {
                        alive[rightIdx] = false;
                        stack.pop();
                        healths[idx]--;
                    } else if (healths[rightIdx] == healths[idx]) {
                        alive[rightIdx] = false;
                        alive[idx] = false;
                        stack.pop();
                        break;
                    } else {
                        healths[rightIdx]--;
                        alive[idx] = false;
                        break;
                    }
                }
            }
        }
        
        List<Integer> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (alive[i]) {
                survivors.add(healths[i]);
            }
        }
        
        return survivors;
    }
}