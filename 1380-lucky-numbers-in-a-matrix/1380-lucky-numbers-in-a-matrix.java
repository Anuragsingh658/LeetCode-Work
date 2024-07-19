class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        
        // Initialize minRow to maximum integer values
        for (int i = 0; i < minRow.length; i++) {
            minRow[i] = Integer.MAX_VALUE;
        }
        
        // Initialize maxCol to minimum integer values
        for (int j = 0; j < maxCol.length; j++) {
            maxCol[j] = Integer.MIN_VALUE;
        }
        
        // Find the minimum value in each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < minRow[i]) {
                    minRow[i] = matrix[i][j];
                }
            }
        }
        
        // Find the maximum value in each column
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > maxCol[j]) {
                    maxCol[j] = matrix[i][j];
                }
            }
        }
        
        // Check for lucky numbers
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}