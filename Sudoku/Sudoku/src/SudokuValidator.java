import java.util.*;
public class SudokuValidator {

    private static final int GRID_SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    public static boolean isValidSudoku(char[][] grid) {
        // Check rows
        for (int i = 0; i < GRID_SIZE; i++) {
            boolean[] seen = new boolean[GRID_SIZE];
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] != '.') {
                    int number = grid[i][j] - '1';
                    if (seen[number] || number < 0 || number >= GRID_SIZE) {
                        return false;
                    }
                    seen[number] = true;
                }
            }
        }

        // Check columns
        for (int j = 0; j < GRID_SIZE; j++) {
            boolean[] seen = new boolean[GRID_SIZE];
            for (int i = 0; i < GRID_SIZE; i++) {
                if (grid[i][j] != '.') {
                    int number = grid[i][j] - '1';
                    if (seen[number] || number < 0 || number >= GRID_SIZE) {
                        return false;
                    }
                    seen[number] = true;
                }
            }
        }

        // Check subgrids
        for (int i = 0; i < GRID_SIZE; i += SUBGRID_SIZE) {
            for (int j = 0; j < GRID_SIZE; j += SUBGRID_SIZE) {
                boolean[] seen = new boolean[GRID_SIZE];
                for (int x = 0; x < SUBGRID_SIZE; x++) {
                    for (int y = 0; y < SUBGRID_SIZE; y++) {
                        if (grid[i + x][j + y] != '.') {
                            int number = grid[i + x][j + y] - '1';
                            if (seen[number] || number < 0 || number >= GRID_SIZE) {
                                return false;
                            }
                            seen[number] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (isValidSudoku(grid)) {
            System.out.println("The Sudoku grid is valid.");
        } else {
            System.out.println("The Sudoku grid is not valid.");
        }
    }
}



