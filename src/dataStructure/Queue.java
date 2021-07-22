package dataStructure;

public class Queue {
  class Node{
	  int data;
	  Node next;
	  Node(int data){
		  this.data = data;
	  }
  }
  Node front;
  Node rear;
  void enqueue(int data) {
	  Node newNode = new Node(data);
	  //because in queue data is added to rear 
	  if(rear == null) {
		  front = rear = newNode;
	  }else {
		  rear.next = newNode;
		  rear = newNode;
	  }
  }
  void display() {
	  if(front == null) {
		  System.out.println("List is empty");
		  return;
	  }
	  Node temp = front;
	  while(temp != null) {
		  System.out.println(temp.data);
		  temp = temp.next;
	  }
  }
  void dequeue() {
	  if(front == null) {
		  System.out.println("empty");
	  }else {
		  front = front.next;
	  }
	  if(front == null) {
		  rear = null;
	  }
  }
public static void main(String[] args) {
	Queue queue = new Queue();
	queue.enqueue(10);
	queue.enqueue(100);
	queue.enqueue(1000);
	queue.dequeue();
	queue.display();
}
  
}
