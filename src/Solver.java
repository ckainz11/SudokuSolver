public class Solver {


    public static void main(String[] args) {
        int[][] sudoku = {
                {3, 1, 6, 4, 0, 8, 0, 2, 5},
                {5, 8, 9, 6, 1, 2, 3, 4, 7},
                {7, 4, 0, 9, 5, 3, 8, 6, 1},
                {2, 6, 8, 0, 9, 1, 4, 7, 3},
                {1, 9, 3, 8, 4, 7, 2, 5, 6},
                {4, 7, 5, 3, 2, 6, 1, 9, 8},
                {8, 2, 4, 1, 6, 5, 7, 0, 9},
                {6, 3, 7, 2, 8, 9, 5, 1, 4},
                {9, 5, 0, 7, 3, 0, 6, 8, 2}
        };
        int[][] sol = solve(sudoku);
        print2d(sol);

    }


    private static int[][] solve(int[][] grid) {
        int[][] finishedGrid = null;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int i = 1; i < 10; i++) {
                        if (isPossible(i, row, col, grid)) {
                            grid[row][col] = i;
                            finishedGrid = copy2d(solve(grid));
                            grid[row][col] = 0;

                        }
                    }

                }
            }
        }
        if(finishedGrid != null)
            return finishedGrid;
        else
            return grid;
    }


    private static boolean isPossible(int number, int row, int col, int[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == number || grid[i][col] == number)
                return false;
        }
        int row0 = (row / 3)*3;
        int col0 = (col / 3)*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[row0 + i][col0 + j] == number)
                    return false;
            }
        }
        return true;
    }

    private static void print2d(int[][] grid) {
        String result = "";
        for(int i=0;i<9;i++){
            String row = "";
            for(int j=0;j<9;j++){
                row += grid[i][j]+" ";
            }
            result+=row+"\n";
        }
        System.out.println(result);
    }
    private static int[][] copy2d(int[][] toCopy){
        int[][] result = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                result[i][j] = toCopy[i][j];
            }
        }
        return result;

    }
}
