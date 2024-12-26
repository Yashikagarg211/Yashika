
import java.util.Random;

public class SudokuGenerator {

    private static final int MIN_GRID_SIZE = 4;
    private static final int MAX_GRID_SIZE = 12;
    private static final int MIN_DIFFICULTY = 1;
    private static final int MAX_DIFFICULTY = 10;

    private static Random random = new Random();

    public static char[][] generateSudokuGrid(int gridSize, int difficulty) {
        if (gridSize < MIN_GRID_SIZE || gridSize > MAX_GRID_SIZE) {
            throw new IllegalArgumentException("Grid size must be between " + MIN_GRID_SIZE + " and " + MAX_GRID_SIZE);
        }

        if (difficulty < MIN_DIFFICULTY || difficulty > MAX_DIFFICULTY) {
            throw new IllegalArgumentException("Difficulty must be between " + MIN_DIFFICULTY + " and " + MAX_DIFFICULTY);
        }

        char[][] grid = new char[gridSize][gridSize];

        // Initialize grid with zeros
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '.';
            }
        }

        // Fill grid with numbers
        fillGrid(grid, 0, 0);

        // Remove numbers to create puzzle
        removeNumbers(grid, difficulty);

        return grid;
    }

    private static boolean fillGrid(char[][] grid, int row, int col) {
        if (col >= grid.length) {
            col = 0;
            row++;
        }

        if (row >= grid.length) {
            return true;
        }

        char[] numbers = shuffleNumbers(grid.length);

        for (char number : numbers) {
            if (isValidNumber(grid, row, col, number)) {
                grid[row][col] = number;

                if (fillGrid(grid, row, col + 1)) {
                    return true;
                }

                grid[row][col] = '.';
            }
        }

        return false;
    }

    private static char[] shuffleNumbers(int gridSize) {
        char[] numbers = new char[gridSize];

        for (int i = 0; i < gridSize; i++) {
            numbers[i] = (char) (i + '1');
        }

        for (int i = 0; i < gridSize; i++) {
            int j = random.nextInt(gridSize);
            char temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        return numbers;
    }

    private static boolean isValidNumber(char[][] grid, int row, int col, char number) {
        // Check row
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == number) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == number) {
                return false;
            }
        }

        // Check subgrid
        int subgridRow = row - row % 3;
        int subgridCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[subgridRow + i][subgridCol + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void removeNumbers(char[][] grid, int difficulty) {
        int numToRemove = (int) (grid.length * grid.length * (difficulty / 10.0));

        for (int i = 0; i < numToRemove; i++) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid.length);

            if (grid[row][col] != '.') {
                grid[row][col] = '.';
            } else {
                i--;
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = generateSudokuGrid(9, 5);
        printGrid(grid);
    }

    private static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
                if ((j + 1) % 3 == 0 && j < grid.length - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i < grid.length - 1) {
            System.out.println("--------+---------+--------");
        }
    }
}
}



