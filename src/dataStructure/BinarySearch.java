package dataStructure;

public class BinarySearch {
 //Method find a value's position in array.
	public static int BinaryIter(int[] array,int target) {
		// Initial start and end Indices.
		int startIdx = 0;
		// array.lenght returns exact length count from 1, but last index will be n-1.
		int endIdx = array.length - 1;
		// Loop until startIdx is greater than endIdx.
		while(startIdx <= endIdx) {
			// find the middle position of array.
			int middle = startIdx + (endIdx - startIdx)/2;
			// Condition of value is in middle index.
			if(array[middle] == target) {
				return middle;
			}
			// Condition of value in middle is less than target.
			else if(array[middle]<target) {
				startIdx = middle + 1;
			}
			// Condition of value in middle is greater than targer. Here we can use 'else' also
			else if(array[middle]>target) {
				endIdx = middle - 1;
			}
		}
		// return -1,after the value is not found in array.
		return -1;
	}
	//Let's make binary search in recursive method also.
	public static int binaryRec(int[]array,int target) {
		//for standard we use a helper function for recursion.
	  return binaryRecHelper(array,target,0,array.length - 1);
	}
	public static int binaryRecHelper(int[] array,int target,int startIdx,int endIdx) {
		// in iterative case we looped until startIdx greater than endIdx.
		if(startIdx>endIdx) {
			return -1;
		}
		// find middle position
		int middle = startIdx + (endIdx - startIdx)/2;
		// check value present in middle position.
		if(array[middle] == target) {
			return middle;
		}
		//Condition for middle position value is greater than target. 
		else if(array[middle] > target) {
			// we can recall function by change endIdx to middle-1.
			return binaryRecHelper(array,target,startIdx,middle-1);
		}
		//Condition for middle position value is less than target.
		else {
			return binaryRecHelper(array,target,middle+1,endIdx);
		}
	}
 public static void main(String[] args) {
	 //Binary search work in sorted data only.
	int[] array = {1,2,3};
  //	System.out.println(BinaryIter(array,434));
	System.out.println(binaryRec(array,24));
}
}
