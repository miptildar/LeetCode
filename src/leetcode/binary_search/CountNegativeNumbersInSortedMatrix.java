package leetcode.binary_search;

class CountNegativeNumbersInSortedMatrix {

    public static void main(String[] args) {
        new CountNegativeNumbersInSortedMatrix().countNegatives(new int[][]{
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        });
    }

    public int countNegatives(int[][] grid) {
        int rowsCount = grid.length;
        int columnsCount = grid[0].length;

        int counter = 0;

        for (int i=0; i<rowsCount; i++) {

            int[] row = grid[i];
            int firstNegativeNumber = firstNegativeNumber(row);
            if (firstNegativeNumber != -1 && firstNegativeNumber < row.length) {
                counter += columnsCount - firstNegativeNumber;
            }

        }

        return counter;
    }

    int firstNegativeNumber(int[] row) {
        int length = row.length;

        int left = 0;
        int right = length - 1;
        int memory = -1;
        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (row[middle] < 0) {
                memory = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return memory;
    }
}
