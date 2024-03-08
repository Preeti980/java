package RecursionBasic;

public class Backtracking {

    // backtracking
    public static void changeArr(int arr[], int i, int val) {
    // base case
    if (i == arr.length) {
    printArr(arr);
    return;
    }
    // recursive
    arr[i] = val;
    changeArr(arr, i + 1, val + 1);//function call step
    arr[i] = arr[i] - 2;//backtracking step
    }
    public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
    }
    System.out.println();
    }
    public static void main(String[] args) {
    int arr[] = new int[5];
    changeArr(arr, 0, 1);
    printArr(arr);
    }
    }

    // find suvsets
    public static void findSubset(String str, String ans, int i) {
    // base case
    if (i == str.length()) {
    System.out.println(ans);
    return;
    }
    // recursion
    // Yes choice
    findSubset(str, ans + str.charAt(i), i + 1);
    // no choice
    findSubset(str, ans, i + 1);
    }
    public static void main(String[] args) {
    String str = "abc";
    findSubset(str, "", 0);
    }

    // find permutation
    public static void findPermutation(String str, String ans) {
    // base case
    if (str.length() == 0) {
    System.out.println(ans);
    return;
    }
    // recursion
    for (int i = 0; i < str.length(); i++) {
    char curr = str.charAt(i);
    // "abcde"=> "ab"+"de"="abde"
    String NewStr = str.substring(0, i) + str.substring(i + 1);
    findPermutation(NewStr, ans + curr);
    }
    }
    public static void main(String args[]) {
    String str = "abc";
    findPermutation(str, "");
    }

    // N Queens
    public static boolean isSafe(char board[][], int row, int col) {
    // vertically up
    for (int i = row - 1; i >= 0; i--) {
    if (board[i][col] == 'Q') {
    return false;
    }
    }
    // diag left up
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
    if (board[i][j] == 'Q') {
    return false;
    }
    }
    // diag right up
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
    if (board[i][j] == 'Q') {
    return false;
    }
    }
    return true;
    }
    public static boolean nQueens(char board[][], int row) {
    // base case
    if (row == board.length) {
    // printBoard(board);
    count++;
    return true;
    }
    // column loop
    for (int j = 0; j < board.length; j++) {
    if (isSafe(board, row, j)) {
    board[row][j] = 'Q';
    if (nQueens(board, row + 1)) {
    return true;
    }
    board[row][j] = 'x';
    }
    }
    return false;
    }
    public static void printBoard(char board[][]) {
    System.out.println("------chess board-----");
    for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board.length; j++) {
    System.out.print(board[i][j] + " ");
    }
    System.out.println();
    }
    }
    static int count = 0;
    public static void main(String[] args) {
    int n = 5;
    char board[][] = new char[n][n];
    // initialize
    for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
    board[i][j] = 'x';
    }
    }
    if (nQueens(board, 0)) {
    System.out.println("solution is possible");
    printBoard(board);
    } else {
    System.out.println("solution is not possible");
    }
    // System.out.println("total ways to solve n queens=" + count);
    }
    }

    // gridWays
    public static int gridWays(int i, int j, int n, int m) {
    if (i == n - 1 && j == m - 1) {// condition for last call
    return 1;
    }
    if (i == n || j == n) {// boundary condition
    return 0;
    }
    return gridWays(i + 1, j, n, m) + gridWays(i, j + 1, n, m);
    }
    public static void main(String args[]) {
    int n = 3, m = 3;
    System.out.println(gridWays(0, 0, n, m));
    }

    // SudokuGrid
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {

        // base case
        if (row == 9 && col == 0) {
            return true;
        }
        // recursion case
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("solution does not exist");
        }
    }
}
