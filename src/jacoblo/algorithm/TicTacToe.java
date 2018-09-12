package jacoblo.algorithm;

import java.util.ArrayList;

public class TicTacToe {
	public static void main(String[] args) {
		char[][] board = {  { 'X', 'X', 'O' },
												{ 'O', 'X', 'O' },
												{ 'O', 'O', 'O' } };
		char[][] board2 = { { 'X', 'X', 'O' },
												{ 'O', 'O', 'X' },
												{ 'X', 'O', 'X' } };
		
		String boards = "X X O O X O O O O";
		String boards2 =  "O O X "
										+ "X O X "
										+ "O X O";
		boolean isValid = isValid(convertToBoard(boards2));
		System.out.println(isValid);
	}
	
	public static char[][] convertToBoard(String sBoard) {
		if (sBoard == null || sBoard.length() <= 0 ) return new char[0][0];
		
		ArrayList<Integer> array = new ArrayList<>();
		for ( int i = 0 ; i < sBoard.length() ; i++ ) {
			if (sBoard.charAt(i) == 'X' || sBoard.charAt(i) == 'O') {
				array.add((int) sBoard.charAt(i));
			}
		}
		
		if (array.size() != 9) {
			return new char[0][0];
		}
		
		int[] result = new int[9];
		for (int i = 0 ; i < array.size(); i++ ) {
			result[i] = array.get(i);
		}
		
		return convertToBoard(result);
	}
	
	public static char[][] convertToBoard(int[] intBoard) {
		if ( intBoard == null || intBoard.length != 9 ) return new char[0][0];
		
		char[][] board = new char[3][3];
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			for ( int j = 0 ; j < 3 ; j++ ) {
				board[i][j] = (char) intBoard[i*3+j];
			}
		}
		
		return board;
	}
	
	public static boolean isValid(char[][] board ) {
		if (board == null || board.length != 3 || board[0].length != 3 ) return false;
		
		int numOfX = 0, numOfO = 0;
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			for ( int j = 0 ; j < 3 ; j++ ) {
				if (board[i][j] == 'X') {
					numOfX++;
				}
				else if (board[i][j] == 'O') {
					numOfO++;
				}
			}
		}
		
		if (!((numOfX == 4 && numOfO == 5) || (numOfX == 5 && numOfO == 4))) {
			return false;
		}
		
		boolean[] checks = new boolean[8];
		int numOfChecksTrue = 0;
		
		for (int r = 0 ; r < 3 ; r++ ) {
			checks[r] = checkAlignRow(board,r);
			if (checks[r]) {
				numOfChecksTrue++;
			}
			if (numOfChecksTrue > 1 ) {
				return false;
			}
		}
		
		numOfChecksTrue = 0;
		for (int c = 0, i = 3; c < 3 ; c++ , i++ ) {
			checks[i] = checkAlignColumn(board,c);
			if (checks[i]) {
				numOfChecksTrue++;
			}
			if (numOfChecksTrue > 1 ) {
				return false;
			}
		}
		
		checks[6] = checkAlignSlash(board, false);
		if (checks[6]) 
			numOfChecksTrue++;
		checks[7] = checkAlignSlash(board, true);
		if (checks[7]) 
			numOfChecksTrue++;
		
		return true;
		
	}
	
	public static boolean checkAlignRow( char[][] board, int currentRow ) {
		return board[currentRow][0] == board[currentRow][1] && board[currentRow][0] == board[currentRow][2];
	}
	
	public static boolean checkAlignColumn( char[][] board, int currentColumn ) {
		return board[0][currentColumn] == board[1][currentColumn] && board[0][currentColumn] == board[2][currentColumn];
	}
	
	public static boolean checkAlignSlash( char[][] board, boolean isBackSlash ) {
		if ( isBackSlash) {
			return board[1][1] == board[2][0] && board[1][1] == board[0][2];
		}
		return board[1][1] == board[2][2] && board[1][1] == board[0][0];
	}
}
