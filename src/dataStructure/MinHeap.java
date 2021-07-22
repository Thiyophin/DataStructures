package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinHeap {
	//we are using arrayList to store values in heap.To use Collection method we use List interface(collections are inherited in it). 
	// globally making object heap for ArrayList
	List<Integer> heap = new ArrayList<>();
	// Constructor for making heap from empty array.
	public  MinHeap() {
		
	}
	// Constructor for making heap from existing array.
	public MinHeap(List<Integer>array) {
		// assign array to globally made object (heap) for arraylist
		heap = array;
		buidMinHeap(heap);
	}
	// To build heap from existing arrayList value
	private void buidMinHeap(List<Integer> heap) {
	 	for(int i = parent(heap.size() - 1); i>= 0; i--) {
	 		shiftDown(i);
	 	}
	}
	// Method for comparing values with parent,left child,right child to find the lowest value(used in building and remove the 0th position in heap.)
	private void shiftDown(int parentIdx) {
		int leftIdx = leftChild(parentIdx);
		int endIdx = heap.size()-1;
		// Only loop if leftIdx is less or equal to endIdx, No need to check rightIdx since after left only right gets filled
		while(leftIdx <= endIdx) {
			int indexToShift;
			int rightIdx = rightChild(parentIdx);
			// checks rightIdx is present and also check rightIdx is smaller
			if(rightIdx <= endIdx && heap.get(leftIdx) > heap.get(rightIdx)) {
				//condition satisfies rightIdx value is smaller, we have to compare with parentIdx
				indexToShift = rightIdx;
			}else {
				//else leftIdx is smaller. we have to compare with parentIdx.
				indexToShift = leftIdx;
			}
			if(heap.get(parentIdx) > heap.get(indexToShift)) {
				// if parentIdx has larger value swap the values using Collection swap property in List
				Collections.swap(heap, parentIdx, indexToShift);
				// we values gets swapped we have update new parentIdx and leftIdx for further checks for shiftDown,if leftIdx gets greater than endIdx While will break
				parentIdx = indexToShift;
				leftIdx = leftChild(parentIdx);
			}else {
				// if ParentIdx's value is smaller just return it.
				return;
			}
		}
	}
	// Method for comparing value with parent and one child.(During insert a value to heap).
	private void shiftUp(int currentIdx) {
		int parentIdx = parent(currentIdx);
		while(parentIdx >=0 && heap.get(parentIdx) > heap.get(currentIdx)) {
			Collections.swap(heap, parentIdx, currentIdx);
			currentIdx = parentIdx;
			parentIdx = parent(currentIdx);
		}
	}
	// MinHeap parent Index finding method
	private int parent(int i) {
		return (i - 1)/2;
	}
	// MinHeap left child Index finding method
	private int leftChild(int i) {
		return (2 * i) + 1;
	}
	// MinHeap right Index finding method
	private int rightChild(int i) {
		return (2 * i) + 2;
	}
	// Method to find the smallest value in heap. Standard name should peek for this method
	public int peek() {
		if(heap.size() == 0)return 0;
		else return heap.get(0);
	}
	// Method to insert a value to Minheap
	public void insert(int value) {
		// add value at the end position of heap ArrayList.
		heap.add(value);
		// then pass last Index to shiftup method to compare value with parent.
		shiftUp(heap.size()-1);
	}
	// Method to remove the 0th position value from MinHeap
	public void remove() {
		// first interchange the 0th position value with last position value
		Collections.swap(heap, 0, heap.size() - 1);
		// then delete the last position value
		heap.remove(heap.size()-1);
		// Check ShiftDown to rearrange values to minHeap.
		shiftDown(0);
	}
	// To display heap values
	public void displayMinHeap() {
		if(heap.size() == 0) {
			System.out.println("MinHeap is empty");
			return;
		}
		for(int i=0 ; i < heap.size() ; i++) {
			System.out.println(heap.get(i));
		}
	}
  public static void main(String[] args) {
	List <Integer>array = new ArrayList<>(Arrays.asList(6,2,8));
	MinHeap min_heap = new MinHeap(array);
//	MinHeap min_heap = new MinHeap();
//	min_heap.displayMinHeap();
	System.out.println("aaaa");
	min_heap.insert(1);
	min_heap.insert(10);
	min_heap.insert(3);
	//min_heap.remove();
	min_heap.displayMinHeap();
	//System.out.println(min_heap.peek());
}
}
