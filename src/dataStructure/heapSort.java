package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class heapSort {
	
	public static void main(String[] args) {
		//make an Array to sort Values.
		List<Integer> array = new ArrayList<>(Arrays.asList(41,5,62,38,647,7,7,21));
		// we can use minHeap or maxHeap for heap sorting.Here i am using maxHeap.
		// We have implemented maxHeap in dataStructure package itself. So lets make an instance for it.
	    MaxHeap maxHeap = new MaxHeap(array); // First make a maxHeap of our array.
	    // After first build we have to swap 0th position and last Position values in array.
	    if(array.size() == 0)return;
	    Collections.swap(array, 0, array.size()-1); // Now the last position of array is Sorted to correctPosition.
	  // Now we have to loop through all values and interChange first value and array.size()-1-j position value,So that Sorting happens from Second last to first value.
	   	int j = 1;
	    for(int i = array.size()-1;i>0;i--) {
	    	// We have change array's endIdx so that the MaxHeap shiftDown don't take our sorted value to top again.
	    	// For that let's take j=1 , then subtract it with array's last Position, SO that to find the position to swap.
	    	// In each shiftDown the endIdx gets changed.
	    	maxHeap.HeapSortShiftDown(0, array.size()-1-j);
	    	Collections.swap(array,0,array.size()-1-j);
	    	 j++;
	    }
		  maxHeap.display();
	}
}
