package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverGraph {
    //method to check how many river present in twoDimensional array passed
	//Method receive two dimensional array and returns a array of integer values refers river present in matrix
	public static List<Integer> FindRiverSize(int[][] matrix){
		boolean[][] visited = new boolean[matrix.length][matrix[0].length]; // same row and column size 2D array to check 0's and 1's in matrix is traveled or not.We keep true if visited or else use false
		List <Integer>sizes = new ArrayList<>(); // we don't know size of array forming the sizes(result), so we use dynamic array(ArrayList).
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				// loop over each position check if visited or not in visited array. If visited continue looping by increment j.
				if(visited[i][j]) {
					continue;
				}
				else {
					TraverseThroughNodes(i,j,matrix,visited,sizes);
				}
			}
		}
		return sizes;
	}
	// Method to countRivers
	// method receives positions(value of row and column),matrix 2D array,visited 2D array,size and returns nothing.
	private static void TraverseThroughNodes(int row,int column,int[][] matrix,boolean[][] visited,List<Integer> sizes){
	// To count river we have to use depth first search(for that we need a stack). (for implementing breadth first search we use Queue).
		int currentRiverSize = 0; // initial count of river
		Stack <Integer[]> nodesToExplore = new Stack<>();
		nodesToExplore.push(new Integer[] {row,column});  // add position of value to stack.
		while(!nodesToExplore.empty()) {   // loop until stack is empty . StackName.empty() returns true or false
			Integer[] currentPosition = nodesToExplore.pop(); // Takeout top value from stack. And store it in currentPosition array.
		    row = currentPosition[0]; //Assign row value of currentPosition.
		    column = currentPosition[1]; //Assign column value of currentPosition.
			// Check currentPosition is visited
			if(visited[row][column]) {
				continue; // if visited loop for next Node in stack.
			}
			visited[row][column] = true; // Now we visited, so make it true.
			if(matrix[row][column] == 0) { // if value in matrix is 0( that is land we have loop again). 
				continue;
			}
			currentRiverSize ++; // Increment the river if it is not visited and value is not 0.
			List<Integer[]>nearest = AdjacentNodes(row,column,matrix,visited); // find the nearest nodes's position(row and column values) of this node.
			// add the nearest nodes to the stack
			nodesToExplore.addAll(nearest);
			
		}
		// End of the while loop counting is done.
		// store the counts if increment or less no need to store 0 (no river present).
		if(currentRiverSize>0) {
			sizes.add(currentRiverSize);
		}
	}
	// Method to find the near Nodes of Node just passed to this function.
	private static List<Integer[]> AdjacentNodes(int row,int column,int[][] matrix,boolean[][] visited){
		List<Integer[]>nearest = new ArrayList<>();
		// Check top  node is present and it is not visited.
		if(row > 0 && !visited[row-1][column]) {
			nearest.add(new Integer[] {row-1,column});
		}
		// Check bottom node is present and it is not visited.
		if(row < matrix.length-1 && !visited[row+1][column]) {
			nearest.add(new Integer[] {row+1,column});		}
		// Check left  node is present and it is not visited.
		if(column > 0 && !visited[row][column-1]) {
			nearest.add(new Integer[] {row,column-1});		
		}
		// Check right node is present and it is not visited.
		if(column < matrix[0].length-1 && !visited[row][column+1]) {
			nearest.add(new Integer[] {row,column+1});		
		}
		return nearest;
	}

	// main function
public static void main(String[] args) {
	int[][] area =   { {1,0,0,1,1},
					   {0,1,1,1,0}, // initialize the area where land and river present.
			           {0,0,0,0,1},
			           {1,0,0,0,1} }; 
	List<Integer>result = FindRiverSize(area);
	result.forEach(System.out::println);
}	
}
