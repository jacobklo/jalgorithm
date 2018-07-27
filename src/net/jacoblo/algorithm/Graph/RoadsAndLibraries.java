
/*
 * MEDIUM
 * 
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 * 
 * The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, HackerLand was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest programmer of HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.
HackerLand has  cities numbered from  to . The cities are connected by  bidirectional roads. A citizen has access to a library if:
Their city contains a library.
They can travel by road from their city to a city containing a library.
The following figure is a sample map of HackerLand where the dotted lines denote obstructed roads:
image
The cost of repairing any road is  dollars, and the cost to build a library in any city is  dollars. If in the above example  and , we would build  roads at a cost of  and  libraries for a cost of . We don't need to rebuild one of the roads in the cycle .
You are given  queries, where each query consists of a map of HackerLand and value of  and . For each query, find the minimum cost of making libraries accessible to all the citizens and print it on a new line.
Function Description
Complete the function roadsAndLibraries in the editor below. It must return the minimal cost of providing libraries to all, as an integer.
roadsAndLibraries has the following parameters:
n: integer, the number of cities
c_lib: integer, the cost to build a library
c_road: integer, the cost to repair a road
cities: 2D array of integers where each  contains two integers representing cities connected by an obstructed road .
Input Format
The first line contains a single integer , denoting the number of queries.
The subsequent lines describe each query in the following format: 
- The first line contains four space-separated integers describing the respective values of , ,  and , the number of cities, number of roads, cost of a library and cost of a road. 
- Each of the next  lines contains two space-separated integers,  and , describing a bidirectional road connecting cities  and .
Constraints





Each road connects two distinct cities.
Output Format
For each query, print an integer denoting the minimum cost of making libraries accessible to all the citizens on a new line.
Sample Input
2
3 3 2 1
1 2
3 1
2 3
6 6 2 5
1 3
3 4
2 4
1 2
2 3
5 6
Sample Output
4
12
Explanation
We perform the following  queries:
HackerLand contains  cities connected by  bidirectional roads. The price of building a library is  and the price for repairing a road is . 
image
The cheapest way to make libraries accessible to all is to:
Build a library in city  at a cost of .
Repair the road between cities  and  at a cost of .
Repair the road between cities  and  at a cost of .
This gives us a total cost of . Note that we don't need to repair the road between cities  and  because we repaired the roads connecting them to city .
In this scenario it's optimal to build a library in each city because the cost of building a library () is less than the cost of repairing a road (). 
image
There are  cities, so the total cost is .
 * 
 */
package net.jacoblo.algorithm.Graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoadsAndLibraries {
//Complete the roadsAndLibraries function below.
  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

    long result = 0;
    int[][] roads = calcRoads(cities, n ) ;
    
    for ( int i = 0 ; i < roads.length ; i++ ) {
      boolean cityHasAccessToLibrary = false;
      for ( int j = 0 ; j < roads[i].length ; j++ ) {
        if ( roads[i][j] == 1 && j < i ) {
          cityHasAccessToLibrary = true;
          setEdgeValue(roads, i, j, 2);
          break;
        }
      }
      if (cityHasAccessToLibrary && c_lib > c_road) {
        result += c_road;
      }
      else {
        result += c_lib;
      }
    }
    
    return result;
  }
  
  static int[][] calcRoads(int[][] cities, int numOfCities) {
    if ( cities == null ||  numOfCities < 0 ) return new int[0][0];
    
    int[][] roads = new int[numOfCities][numOfCities];
    
    for ( int i = 0 ; i < cities.length ; i++ ) {
      setEdgeValue( roads, cities[i][0] - 1, cities[i][1] - 1, 1);
    }
    
    return roads;
  }
  
   static boolean setEdgeValue ( int[][] roads, int n1, int n2, int newValue ) {
     if ( roads == null || n1 < 0 || n2 < 0 || roads.length <= 0 ) return false;
     roads[ n1 ][ n2 ] = newValue;
     roads[ n2 ][ n1 ] = newValue;
     return true;
   }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/j/Desktop/input03.txt"));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
        String[] nmC_libC_road = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmC_libC_road[0]);

        int m = Integer.parseInt(nmC_libC_road[1]);

        int c_lib = Integer.parseInt(nmC_libC_road[2]);

        int c_road = Integer.parseInt(nmC_libC_road[3]);

        int[][] cities = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] citiesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int citiesItem = Integer.parseInt(citiesRowItems[j]);
                cities[i][j] = citiesItem;
            }
        }

        long result = roadsAndLibraries(n, c_lib, c_road, cities);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
    
    int n = 6;
    int m = 6;
    int c_lib = 2;
    int c_road = 3;
    int[][] cities = {
        { 1, 3 }
        ,{ 3, 4 }
        ,{ 2, 4 }
        ,{ 1, 2 }
        ,{ 2, 3 }
        ,{ 5, 6 } };
    
    int n2 = 3;
    int m2 = 3;
    int c_lib2 = 2;
    int c_road2 = 1;
    int[][] cities2 = {
        { 1, 2}
        ,{ 3, 1 }
        ,{ 2, 3 }
    };
    
    int n3 = 9;
    int m3 = 2;
    int c_lib3 = 91;
    int c_road3 = 84;
    int[][] cities3 = {
        { 8, 2 }
        ,{ 2, 9 } };
    
    
    int n4 = 5;
    int m4 = 9;
    int c_lib4 = 92;
    int c_road4 = 23;
    int[][] cities4 = {
          {2, 1}
          ,{5, 3}
          ,{5, 1}
          ,{3, 4}
          ,{3, 1}
          ,{5, 4}
          ,{4, 1}
          ,{5, 2}
          ,{4, 2} };
    
    int n6 = 2;
    int m6 = 0;
    int c_lib6 = 102;
    int c_road6 = 1;
    int[][] cities6 = {};
    
    int n5 = 1;
    int m5 = 0;
    int c_lib5 = 5;
    int c_road5 = 3;
    int[][] cities5 = {};
    
    int n7 = 8;
    int m7 = 3;
    int c_lib7 = 10;
    int c_road7 = 55;
    int[][] cities7 = {
        { 6, 4 }
        ,{ 3, 2}
        ,{ 7, 1} 
    };
}
    
    
  
}
