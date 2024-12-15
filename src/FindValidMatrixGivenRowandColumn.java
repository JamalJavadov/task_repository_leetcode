public class FindValidMatrixGivenRowandColumn {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int min = 0;
        int[][] matrix = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                if (rowSum[i] >= colSum[j]) {
                    min = colSum[j];
                } else {
                    min = rowSum[i];
                }
                matrix[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;

            }

        }
        return matrix;
    }
}
