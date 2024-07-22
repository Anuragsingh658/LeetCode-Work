class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         // Create an array of indices
        Integer[] indices = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(heights[i2], heights[i1]);
            }
        });

        // Create a new array for the sorted names
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < indices.length; i++) {
            sortedNames[i] = names[indices[i]];
        }

        return sortedNames;
    }
}