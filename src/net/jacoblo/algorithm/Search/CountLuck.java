
/**
 * Medium
 * https://www.hackerrank.com/challenges/count-luck/problem
 * 
 * Ron and Hermione are deep in the Forbidden Forest collecting potion ingredients, and they've managed to lose their way. The path out of the forest is blocked, so they must make their way to a portkey that will transport them back to Hogwarts.
Consider the forest as an  grid. Each cell is either empty (represented by .) or blocked by a tree (represented by ). Ron and Hermione can move (together inside a single cell) LEFT, RIGHT, UP, and DOWN through empty cells, but they cannot travel through a tree cell. Their starting cell is marked with the character , and the cell with the portkey is marked with a . The upper-left corner is indexed as .
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
In example above, Ron and Hermione are located at index  and the portkey is at . Each cell is indexed according to Matrix Conventions.
Hermione decides it's time to find the portkey and leave. They start along the path and each time they have to choose a direction, she waves her wand and it points to the correct direction. Ron is betting that she will have to wave her wand exactly times. Can you determine if Ron's guesses are correct?
The map from above has been redrawn with the path indicated as a series where  is the starting point (no decision in this case),  indicates a decision point and  is just a step on the path:
.X.X.10000X
.X*0X0XXX0X
.XX0X0XM01.
...100XXXX.
There are three instances marked with  where Hermione must use her wand.
Note: It is guaranteed that there is only one path from the starting location to the portkey.
Input Format
The first line contains an integer , the number of test cases.
Each test case is described as follows: 
The first line contains  space-separated integers  and , the number of forest matrix rows and columns. 
Each of the next  lines contains a string of length  describing a row of the forest matrix. 
The last line contains an integer , Ron's guess as to how many times Hermione will wave her wand.
Constraints



There will be exactly one  and one  in the forest.
Exactly one path exists between  and .
Output Format
On a new line for each test case, print  if Ron impresses Hermione by guessing correctly. Otherwise, print .
Sample Input
3
2 3
*.M
.X.
1
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
3
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
4
Sample Output
Impressed
Impressed
Oops!
Explanation
For each test case,  denotes the number of times Hermione waves her wand.
Case 0: Hermione waves her wand at , giving us . Because , we print  on a new line. 
Case 1: Hermione waves her wand at , , and , giving us . Because , we print  on a new line. 
Case 2: Hermione waves her wand at , , and , giving us . Because  and ,  and we print  on a new line.
 */
package net.jacoblo.algorithm.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountLuck {
//Complete the countLuck function below.
  static String countLuck(String[] matrix, int k) {

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    /*
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
          String[] nm = scanner.nextLine().split(" ");

          int n = Integer.parseInt(nm[0]);

          int m = Integer.parseInt(nm[1]);

          String[] matrix = new String[n];

          for (int i = 0; i < n; i++) {
              String matrixItem = scanner.nextLine();
              matrix[i] = matrixItem;
          }

          int k = scanner.nextInt();
          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          String result = countLuck(matrix, k);

          bufferedWriter.write(result);
          bufferedWriter.newLine();
      }

      bufferedWriter.close();

      scanner.close();
      */
    
    String[] matrix = { ".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX." };
    String result = countLuck(matrix, 4);
    System.out.println(result);
  }
}
