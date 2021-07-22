package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class MaxHeap {
	List <Integer> heap = new ArrayList<>();
	public MaxHeap() {
		
	}
	public MaxHeap(List<Integer>array) {
		heap = array;
		buildMaxHeap(heap);
	}
	private void buildMaxHeap(List<Integer>heap) {
		for(int i=parent(heap.size()-1); i>=0 ; i--) {
			shiftDown(i);
		}
	}
//-------*-----------------------*-----------------*--------------------*-----------------------------// Method for heap Sort	
	// ShiftDown for heapSort Each time the endIdx gets changed here.
	public void HeapSortShiftDown(int parentIdx,int endIdx) {
		int leftIdx = leftChild(parentIdx);
		while(leftIdx<=endIdx) {
			int rightIdx = rightChild(parentIdx);
			int indexToShift;
			if(rightIdx <= endIdx && heap.get(leftIdx) < heap.get(rightIdx)) {
				indexToShift = rightIdx;
			}else {
				indexToShift = leftIdx;
			}
			if(heap.get(parentIdx) < heap.get(indexToShift)) {
				Collections.swap(heap, parentIdx, indexToShift);
				parentIdx = indexToShift;
				leftIdx = leftChild(parentIdx);
			}else {
				return;
			}
		}
	}
//-------*-----------------------*-----------------*--------------------*-----------------------------// Method for heap Sort	
	private void shiftDown(int parentIdx) {
		int leftIdx = leftChild(parentIdx);
		int endIdx = heap.size()-1;
		while(leftIdx <= endIdx) {
			int rightIdx = rightChild(parentIdx);
			int indexToShift;
			if(rightIdx <= endIdx && heap.get(leftIdx) < heap.get(rightIdx)) {
				indexToShift = rightIdx;
			}else {
				indexToShift = leftIdx;
			}
			if(heap.get(parentIdx) < heap.get(indexToShift)) {
				Collections.swap(heap, parentIdx, indexToShift);
				parentIdx = indexToShift;
				leftIdx = leftChild(parentIdx);
			}else {
				return;
			}
		}
	}
	private void shiftUp(int currentIdx) {
		int parentIdx = parent(currentIdx);
		while(currentIdx > 0 && heap.get(parentIdx) < heap.get(currentIdx)) {
			Collections.swap(heap, parentIdx, currentIdx);
			currentIdx = parentIdx;
			parentIdx = parent(currentIdx);
		}
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	private int leftChild(int i) {
		return (2*i)+1;
	}
	private int rightChild(int i) {
		return (2*i)+2;
	}
	public void remove() {
		Collections.swap(heap, 0, heap.size()-1);
		heap.remove(heap.size()-1);
		shiftDown(0);
	}
	public int peek() {
		return heap.get(0);
	}
	public void insert(int value) {
		heap.add(value);
		shiftUp(heap.size()-1);
	}
	public void display(){
		if(heap.size()==0) {
			System.out.println("MaxHeap is empty");
			return;
		}
		for(int i=0 ; i<heap.size() ; i++) {
		   System.out.print(heap.get(i)+" ");
		}
		
	}
	
  public static void main(String[] args) {
	List<Integer>array = new ArrayList<>(Arrays.asList(333,555,666));
	MaxHeap heap = new MaxHeap(array);
	//MaxHeap heap = new MaxHeap();
	heap.insert(4);
	heap.insert(1);
	heap.insert(43);
	heap.insert(42);
	heap.insert(432);
	heap.insert(444);
	heap.insert(7);
	heap.remove();
	heap.display();
	System.out.println("Largest value in Maxheap : "+heap.peek());
}
}
