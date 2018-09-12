package jacoblo.algorithm.Backtracking;

import java.util.ArrayList;

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
		solveSudoku(board);
		System.out.println(printSudokuArray(board));
	}
	
	public static boolean solveSudoku(int[][] board) {
	  if (board == null || board.length != 9 || board[0].length != 9) return false;
	  ArrayList<ArrayList<Integer>> unsolve = getAllUnsolve(board);
    return solveSudoku(board, unsolve, 0, unsolve.size());
	}
	
	public static boolean solveSudoku(int[][] board, ArrayList<ArrayList<Integer>> unsolvedSoFar, int solvingIndex, int numOfUnAnswered) {
		if (board == null || board.length != 9 || board[0].length != 9) return false;
		
		if (numOfUnAnswered <= 0) {
		  return true;
		}
	
		int x = unsolvedSoFar.get(solvingIndex).get(0);
		int y = unsolvedSoFar.get(solvingIndex).get(1);
    
		for ( int i = 1 ; i <= 9 ; i++ ) {
		  int curResult = getMove(board, x,y,i ) ;
		  if (curResult > 0) {
		    board[x][y] = curResult;
		    
		    if (unsolvedSoFar.size() >= 1) {
		      boolean subResult = solveSudoku(board,unsolvedSoFar,solvingIndex+1, numOfUnAnswered-1);
		      if (subResult) {
		        return true;
		      }
		      else {
		        board[x][y] = 0;
		      }
		    }
		  }
		}
		
		return false;
	}
	
	private static int getMove(int[][] board, int x, int y, int number) {
		if (board == null || board.length != 9 || board[0].length != 9 || x < 0 || x > 9 || y < 0 || y > 9) return 0;
		
		if (board[x][y] > 0) return board[x][y];
		
    if (rowContains(board,x,y,number).size() > 0)  return 0;
    if (columnContains(board,x,y,number).size() > 0) return 0;
    if (boxContains(board,x,y,number).size() > 0)  return 0;
    
		return number;
	}
	
	private static ArrayList<ArrayList<Integer>> getAllUnsolve(int[][] board) {
	  if (board == null || board.length != 9 || board[0].length != 9 ) return new ArrayList<>();
	  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	  
	  for ( int i = 0 ; i < 9 ; i++ ) {
	    for ( int j = 0 ; j < 9 ; j++ ) {
	      if (board[i][j] == 0 ) {
	        ArrayList<Integer> newUnsolve = new ArrayList<>();
	        newUnsolve.add(i);
	        newUnsolve.add(j);
	        result.add(newUnsolve);
	      }
	    }
	  }
	  
	  return result;
	}
	
	private static ArrayList<ArrayList<Integer>> rowContains(int[][] board, int row, int column, int number) {
	  if (board == null || board.length != 9 || board[0].length != 9 || row < 0 || row > 9 || column < 0 || column > 9 || number < 0 || number > 9) return new ArrayList<>();
	  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	  for (int c = 0 ; c < board[row].length ; c++ ) {
	    if (c != column && board[row][c] == number) {
	      ArrayList<Integer> coord = new ArrayList<>();
	      coord.add(row);
	      coord.add(c);
	      result.add(coord);
	    }
	  }
	  
	  return result;
	}
	
	private static ArrayList<ArrayList<Integer>> columnContains(int[][] board, int row, int column, int number) {
	  if (board == null || board.length != 9 || board[0].length != 9 || row < 0 || row > 9 || column < 0 || column > 9 || number < 0 || number > 9) return new ArrayList<>();
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for ( int r = 0 ; r < board.length ; r++ ) {
      if (r != row && board[r][column] == number) {
        ArrayList<Integer> coord = new ArrayList<>();
        coord.add(r);
        coord.add(column);
        result.add(coord);
      }
    }
    
    return result;
  }
	
	private static ArrayList<ArrayList<Integer>> boxContains(int[][] board, int row, int column, int number) {
		if (board == null || board.length != 9 || board[0].length != 9 || column < 0 || column > 9 || row < 0 || row > 9 || number < 0 || number > 9) return new ArrayList<>();
		
		int startRow = 0, startColumn = 0;
		if (row >= 6)	startRow = 6;
		else if (row >= 3 ) startRow = 3;
		if ( column >= 6) startColumn = 6;
		else if ( column >= 3 ) startColumn = 3;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = startRow ; i < startRow + 3 ; i++) {
			for (int j = startColumn ; j < startColumn + 3 ; j++) {
				if (i != row && j != column && board[i][j] == number) {
	        ArrayList<Integer> coord = new ArrayList<>();
	        coord.add(i);
	        coord.add(j);
	        result.add(coord);
				}
			}
		}
		
		return result;
	}
	
	public static String printSudokuArray(int[][] board) {
	  if (board == null || board.length != 9 || board[0].length != 9) return "";
	  
	  String result = "";
    for (int i = 0 ; i < board.length ; i++) {
      for (int j = 0 ; j < board[i].length ; j++) {
        result += board[i][j] + " ";
      }
    }
    
    return result;
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
