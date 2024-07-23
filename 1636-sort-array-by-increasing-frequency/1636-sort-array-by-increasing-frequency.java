class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the array with a custom comparator
        Integer[] sortedArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);
                if (freqA == freqB) {
                    return b - a; 
                }
                return freqA - freqB; 
            }
        });

        // Convert back to primitive int array
        return Arrays.stream(sortedArray).mapToInt(Integer::intValue).toArray();
    }
}