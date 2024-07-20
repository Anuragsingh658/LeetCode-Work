class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
         int numRows = rowSum.length;
        int numCols = colSum.length;
        int[][] result = new int[numRows][numCols];
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int minValue = Math.min(rowSum[i], colSum[j]);
                result[i][j] = minValue;
                rowSum[i] -= minValue;
                colSum[j] -= minValue;
            }
        }
        
        return result;
    }
}