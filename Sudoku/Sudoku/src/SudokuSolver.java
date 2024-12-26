import java.util.Scanner;

// DEFINING THE SUDOKU BOARD DATA STRUCTURE

public class SudokuSolver{
     private char[][] board;

    public SudokuSolver(){
        board = new char[9][9];
    }
    public char[][] getBoard(){
        return board;
    }
    public void setBaord(char[][] board){
        this.board = board;
    }

// IMPLEMENTING SUDOKU BOARD INPUT 

    public void inputBoard(){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print("Enter value for row "+ (i+1) + " column " + (j+1) + " (0-9 or '.'): ");
                char value = scanner.next().charAt(0);
                if (value >= '0' && value <= '9'){
                    board[i][j] = value;
                } else if (value == '.'){
                    board[i][j] = '.';
                } else {
                    System.out.println("Invalid input. Please enter a digit (0-9) or '.'.");
                    j--;
                }
            }
        }
    }

// IMPLEMENT SUDOKU BOARD PRINTING

    public void printBoard(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
                if ((j+1) % 3 == 0 && j<8){
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i+1) % 3 == 0 && i<8){
                System.out.println("---------+---------+---------");
            }
        }
    }

// IMPLEMENT SUDOKU VALIDATION

   public boolean isValid(char num, int row, int col) {
    // Check if the number already exists in the same row or column
    for (int i = 0; i < 9; i++) {
        if (board[row][i] == num || board[i][col] == num) {
            return false;
        }
    }

    // Check if the number exists in the 3x3 sub-grid
    int subGridRow = row - row % 3;
    int subGridCol = col - col % 3;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[subGridRow + i][subGridCol + j] == num) {
                return false;
            }
        }
    }

    return true;
}

// IMPLEMENT SUDOKU SOLVING

public boolean solve() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(num, i, j)) {
                        board[i][j] = num;
                        if (solve()) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }
    return true;
}

// MAIN METHOD THAT TIES EVERYTHING TOGETHER

   public static void main(String[] args){
    SudokuSolver sudoku = new SudokuSolver();
    sudoku.inputBoard();
    sudoku.printBoard();
    if (sudoku.solve()){
        System.out.println("Solved Sudoku board:");
        sudoku.printBoard();
    } else {
        System.out.println("No solution exists for the given Sudoku board.");
    }
   }
}
