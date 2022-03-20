package again;



class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        // i 0 n / 2
        for (int i = 0; i < n / 2; ++i) {
            // 里边每一个j都进行翻转
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                // n - i - 1 就是对照组
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            // 因为是主对角线，所以 j < i
            for (int j = 0; j < i; ++j) {
                // 进行 i j 相互转换即可
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
