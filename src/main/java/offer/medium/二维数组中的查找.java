package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/1 17:15
 */
public class 二维数组中的查找 {

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray3(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(findNumberIn2DArray3(new int[][]{{1}, {3}, {5}}, 5));
        System.out.println(findNumberIn2DArray3(new int[][]{{1, 4}, {2, 5}}, 5));
        System.out.println(findNumberIn2DArray3(new int[][]{{1, 4}, {2, 5}}, 5));
        System.out.println(findNumberIn2DArray3(new int[][]{{1, 1}}, 0));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 1) {
            for (int i : matrix[0]) {
                if (i == target) {
                    return true;
                }
            }
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0] <= target) {
                for (int j : matrix[i]) {
                    if (j == target) {
                        return true;
                    }
                }
            }
            if (matrix[i + 1][0] <= target) {
                for (int j : matrix[i + 1]) {
                    if (j == target) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix.length == 1) {
            for (int i : matrix[0]) {
                if (i == target) {
                    return true;
                }
            }
            return false;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (target == matrix[i][0]) {
                    return true;
                }
            }
            return false;
        }
        int m = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (m >= 0 && matrix[i][m] >= target) {
                if (matrix[i][m] == target) {
                    return true;
                }
                if (matrix[i][m] < target) {
                    break;
                }
                m--;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }


}
