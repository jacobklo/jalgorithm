package net.jacoblo.algorithm.Backtracking;

public class Sudoku {
	public static void main (String[] args) {
		int[][] board = { { 3, 0, 6,  5, 0, 8,  4, 0, 0 },
											{ 5, 2, 0,  0, 0, 0,  0, 0, 0 },
											{ 0, 8, 7,  0, 0, 0,  0, 3, 1 },
											
											{ 0, 0, 3,  0, 1, 0,  0, 8, 0 },
											{ 9, 0, 0,  8, 6, 3,  0, 0, 5 },
											{ 0, 5, 0,  0, 9, 0,  6, 0, 0 },
											
											{ 1, 3, 0,  0, 0, 0,  2, 5, 0 },
											{ 0, 0, 0,  0, 0, 0,  0, 7, 4 },
											{ 0, 0, 5,  2, 0, 6,  3, 0, 0 } };
		
		
		System.out.println(printSudoku(board));
	}
	
	public static int[][] solveSudoku(int[][] board, int x, int y) {
		if (board == null || board.length != 9 || board[0].length != 9) return new int[0][0];
		
		return board;
	}
	
	private static int getMove(int[][] board, int x, int y) {
		if (board == null || board.length != 9 || board[0].length != 9 || x < 0 || x > 9 || y < 0 || y > 9) return 0;
		
		if (board[x][y] > 0) return board[x][y];
		
		for (int i = 1 ; i <= 9 ; i++ ) {
			// check if illegal
			if (rowContains(board,x,i))	return 0;
			if (columnContains(board,y,i))	return 0;
			if (boxContains(board,x,y,i))	return 0;
			
			// TODO : 
		}
	}
	
	private static boolean rowContains(int[][] board, int row, int number) {
		if (board == null || board.length != 9 || board[0].length != 9 || row < 0 || row > 9 || number < 0 || number > 9) return false;
		
		for ( int column = 0 ; column < board[row].length ; column++ ) {
			if (board[row][column] == number) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean columnContains(int[][] board, int column, int number) {
		if (board == null || board.length != 9 || board[0].length != 9 || column < 0 || column > 9 || number < 0 || number > 9) return false;
		
		for ( int row = 0 ; row < board.length ; row++ ) {
			if (board[row][column] == number) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean boxContains(int[][] board, int row, int column, int number) {
		if (board == null || board.length != 9 || board[0].length != 9 || column < 0 || column > 9 || row < 0 || row > 9 || number < 0 || number > 9) return false;
		
		int startRow = 0, startColumn = 0;
		if (row >= 6)	startRow = 6;
		else if (row >= 3 ) startRow = 3;
		if ( column >= 6) startColumn = 6;
		else if ( column >= 3 ) startColumn = 3;
		
		for (int i = startRow ; i < startRow + 3 ; i++) {
			for (int j = startColumn ; j < startColumn + 3 ; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String printSudoku(int[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) return "";
		
		String result = "";
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[i].length ; j++) {
				result += board[i][j] + " ";
				if (j == 2 || j == 5 ) {
					result += "| ";
				}
			}
			result += "\n";
			if (i == 2 || i == 5 ) {
				result += "---------------------\n";
			}
		}
		
		return result;
	}
}
