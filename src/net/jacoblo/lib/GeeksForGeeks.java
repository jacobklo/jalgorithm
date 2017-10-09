package net.jacoblo.lib;

import java.util.ArrayList;
import java.util.Scanner;

import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;

/**
 * This Class translate inputs string from geeksforgeeks to correct input
 * @author Jacob Lo
 *
 */
public class GeeksForGeeks {
  
  public enum Parameter {
    NUMBER,
    ARRAY,
    MATRIXRECTANGLE,
    MATRIXSQUARE,
    STRING,
    GRAPH
  }
  
  public static class Case {
    ArrayList<Object> InputPara;
    
    public Case() {
      InputPara = new ArrayList<>();
    }
    
    public Object get(int index) {
      return InputPara.get(index);
    }
  }
  
  public static String[] getInputs(Parameter[] para) {
  	ArrayList<String> result = new ArrayList<>();
  	Scanner scan = new Scanner(System.in);
  	
  	int numOfCases = scan.nextInt();
  	result.add(Integer.toString(numOfCases));
  	
  	for (int c = 0 ; c < numOfCases ; c++) {
  		for (Parameter p : para) {
  			if (p == Parameter.NUMBER) {
  				result.add(scan.next());
  			}
  			else if ( p == Parameter.STRING ) {
  				result.add(scan.next());
  			}
  			else if (p == Parameter.ARRAY) {
  				int numOfItems = scan.nextInt();
  				result.add(Integer.toString(numOfItems));
  				
  				for (int i = 0 ; i < numOfItems ; i++) {
  					result.add(scan.next());
  				}
  			}
  			else if ( p == Parameter.GRAPH ) {
  			  int numOfVertices = scan.nextInt();
  			  result.add(Integer.toString(numOfVertices));
  			  int numOfColor = scan.nextInt();
  			  result.add(Integer.toString(numOfColor));
  			  int numOfEdges = scan.nextInt();
  			  result.add(Integer.toString(numOfEdges));
  			  
  			  for (int i = 0 ; i < numOfEdges * 2 ; i++) {
  			    result.add(scan.next());
  			  }
  			}
  			else if (p == Parameter.MATRIXRECTANGLE || p == Parameter.MATRIXSQUARE) {
  				int numOfRow = scan.nextInt();
  				result.add(Integer.toString(numOfRow));
          int numOfColumn = numOfRow;
          if (p == Parameter.MATRIXRECTANGLE) {
          	numOfColumn = scan.nextInt();
            result.add(Integer.toString(numOfColumn));
          }
          for (int i = 0 ; i < numOfRow * numOfColumn ; i++) {
          	result.add(scan.next());
          }
  			}
  		}
  	}
  	
  	scan.close();
  	
  	String[] resultString = new String[result.size()];
  	for (int i = 0 ; i < resultString.length ; i++) {
  		resultString[i] = result.get(i);
  	}
  	return resultString;
  }
  
  public static Case[] calc(String[] inputs, Parameter[] para) {
  	String[] types = new String[para.length];
  	for (int i = 0 ; i < types.length ; i++) {
  		types[i] = "Integer";
  	}
  	return calc(inputs, para, types);
  }
  
  public static Case[] calc(String[] inputs, Parameter[] para, String[] types) {
    if (inputs == null || para == null || inputs.length == 0 || para.length == 0) return new Case[0];
    
    // First input, it is test cases number
    int numOfTestCase = Integer.parseInt(inputs[0]);
    
    // For each test case, calculate input. For each question we actually don't need the parameters, so we need input para
    ArrayList<Case> cases = new ArrayList<>();
    
    int i = 1;
    for (int c = 0 ; c < numOfTestCase ; c++ ) {
      Case newInputPara = new Case();
      for (int p = 0 ; p < para.length ; p++) {
      	Parameter currentPara = para[p];
      	String currentType = types[p];
        if (currentPara == Parameter.NUMBER) {
        	if (currentType.equals("Integer")) {
        		Integer currentInteger = Integer.parseInt(inputs[i]);
            newInputPara.InputPara.add(currentInteger);
        	}
        	else {
        		Double currentDouble = Double.parseDouble(inputs[i]);
            newInputPara.InputPara.add(currentDouble);
        	}
          i++;
        }
        else if (currentPara == Parameter.STRING ) {
        	newInputPara.InputPara.add(inputs[i]);
        	i++;
        }
        else if (currentPara == Parameter.ARRAY) {
          int sizeOfCurrentArray = Integer.parseInt(inputs[i]);

          if (currentType.equals("Integer")) {
          	int[] currentArray = new int[sizeOfCurrentArray];
            for ( int j = 1 ; j <= sizeOfCurrentArray ; j++) {
              currentArray[j-1] = Integer.parseInt(inputs[i+j]);
            }
            newInputPara.InputPara.add(currentArray);
          }
          else {
          	double[] currentArray = new double[sizeOfCurrentArray];
            for ( int j = 1 ; j <= sizeOfCurrentArray ; j++) {
              currentArray[j-1] = Double.parseDouble(inputs[i+j]);
            }
            newInputPara.InputPara.add(currentArray);
          }
          
          i += sizeOfCurrentArray+1; // remember i++?
        }
        else if (currentPara == Parameter.GRAPH) {
          int numOfVertices = Integer.parseInt(inputs[i]);
          i++;
          int numOfColor = Integer.parseInt(inputs[i]);
          i++;
          int numOfEdges = Integer.parseInt(inputs[i]);
          
          UndirectedGraph<BasicVertex<Integer>,BasicEdge<Integer>> graph = new UndirectedGraph<>();
          for (int v = 0 ; v < numOfVertices ; v++) {
            BasicVertex<Integer> newVertex = new BasicVertex<>(""+v,v,v);
            graph.addVertex(newVertex);
          }
          for (int e = 1 ; e <= numOfEdges * 2 ; e=e+2) {
            int fromVertex = Integer.parseInt(inputs[i+e])-1; // start from 0 instead of 1
            int toVertex = Integer.parseInt(inputs[i+e+1])-1;
            UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(graph.getVertices().get(fromVertex),graph.getVertices().get(toVertex),1);
          }
          
          newInputPara.InputPara.add(graph);
          newInputPara.InputPara.add(numOfColor);
          i += numOfEdges * 2 +1; // remember i++?
          
        }
        else if (currentPara == Parameter.MATRIXRECTANGLE) {
          int numOfRow = Integer.parseInt(inputs[i]);
          i++;
          int numOfColumn = Integer.parseInt(inputs[i]);
          i++;
          
          i = createMatrix(inputs, i, newInputPara, currentType, numOfRow, numOfColumn);
        }
        else if(currentPara == Parameter.MATRIXSQUARE) {
        	int numOfRowColumn = Integer.parseInt(inputs[i]);
          i++;
          
          i = createMatrix(inputs, i, newInputPara, currentType, numOfRowColumn, numOfRowColumn);
        }
      }
      cases.add(newInputPara);
    }
    
    
    Case[] result = new Case[cases.size()];
    result = cases.toArray(result);
    return result;
  }

	private static int createMatrix(String[] inputs, int i, Case newInputPara, String currentType, int numOfRow,
	    int numOfColumn) {
		if (currentType.equals("Integer")) {
			int[][] currentMatrix = new int[numOfRow][numOfColumn];
			for (int a = 0 ; a < currentMatrix.length ; a++) {
				currentMatrix[a] = new int[currentMatrix[a].length];
				for (int b = 0 ; b < currentMatrix[a].length ; b++) {
					currentMatrix[a][b] = Integer.parseInt(inputs[i]);
					i++;
		  	}
			}
			newInputPara.InputPara.add(currentMatrix);
		}
		else {
			double[][] currentMatrix = new double[numOfRow][numOfColumn];
			for (int a = 0 ; a < currentMatrix.length ; a++) {
				currentMatrix[a] = new double[currentMatrix[a].length];
				for (int b = 0 ; b < currentMatrix[a].length ; b++) {
					currentMatrix[a][b] = Double.parseDouble(inputs[i]);
					i++;
		  	}
			}
			newInputPara.InputPara.add(currentMatrix);
		}
		return i;
	}
  
}
