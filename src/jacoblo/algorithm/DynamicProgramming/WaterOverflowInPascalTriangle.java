
/**
 * Water Overflow
 * Medium
 * http://practice.geeksforgeeks.org/problems/champagne-overflow/0
 * Not Pass
 * There is a stack of water glasses in a form of pascal triangle and a person wants to pour the water at the topmost glass, but the capacity of each glass is 1 unit . Overflow takes place in such a way that after 1 unit, 1/2 of remaining unit gets into bottom left glass and other half in bottom right glass.

Now the pours K units of water in the topmost glass and wants to know how much water is there in the jth glass of the ith row.

Assume that there are enough glasses in the triangle till no glass overflows. 

Input:   First line of the input contains an integer T denoting the number of test cases and each test case consists of three lines. First line contain an integer K, second line contains an integer i and third line contains an integer j.


Output: Corresponding to each test case output the remaining amount of water in jth cup of the ith row correct to 6 decimal places.


Constraints:

T<=20
K<=1000
i <= K
j<= K
                
Example:
Input:

1
3 
2
1

Output:
1
 */
package jacoblo.algorithm.DynamicProgramming;

public class WaterOverflowInPascalTriangle {
	public static void main(String[] args) {
		int kunitsOfwater = 9;
		int glassAtRow = 3;
		int glassAtColumn = 3;
		double[][] glasses = new double[glassAtRow+1][glassAtRow+1];
		
		addWaterToGlassesTower(glasses,kunitsOfwater,0,0);
		double result = getWaterInGlass(glasses,glassAtRow-1,glassAtColumn-1);
		System.out.println(result);
		
	}
	
	public static double getWaterInGlass (double[][] glasses, int row, int column) {
		if (glasses == null || glasses.length <= 0 ||  row < 0 || column < 0 || column > row + 1 ) return 0.0;
		
		return glasses[row][column];
	}
	//												 						1
	//															1/2					1/2
	//												1/4					1/2					1/4
	//								1/8						1/4					1/4					1/8
	// 				1/16						1/8					1/4					1/8					1/6
	// 1/32						1/16					1/8					1/8					1/16				1/32
	public static void addWaterToGlassesTower(double[][] glasses, double unitsOfWater, int currentRow, int currentColumn) {
		if (glasses == null || glasses.length <= 0 || unitsOfWater <= 0 || currentRow < 0 || currentColumn < 0 || currentColumn > currentRow + 1 ) return;
		
		if (glasses.length <= currentRow || glasses[0].length <= currentColumn) {
			return;
		}
		glasses[currentRow][currentColumn] += unitsOfWater;
		// if smaller than 1, it mean this glass already taken all, return
		if (unitsOfWater < 1) {
			return;
		}
		unitsOfWater--;
		
		addWaterToGlassesTower(glasses, unitsOfWater / 2, currentRow + 1, currentColumn);
		addWaterToGlassesTower(glasses, unitsOfWater / 2, currentRow + 1, currentColumn + 1);
		
	}
}
