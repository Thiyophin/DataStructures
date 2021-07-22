package dataStructure;

public class DLinkedList {
  class Node{
	  int data;
	  Node next;
	  Node prev;
	  Node(int data){
		  this.data = data;
	  }
  }
  public Node head;
  public Node tail;
  public void addNode(int data) {
	  Node newNode = new Node(data);
	  if(head == null) {
		  head = newNode;
	  }else {
		  tail.next = newNode;
		  newNode.prev = tail;
	  }
	  tail = newNode;
	  //System.out.println("Node added");
  }
  public void displayForward() {
	  Node temp = head;
	  if(head == null) {
		  System.out.println("Empty node");
		  return;
	  }
	  while(temp!=null) {
		  System.out.println(temp.data);
		  temp = temp.next;
	  }
	  
  }
  public void displayBackward() {
	  Node temp = tail;
	  if(tail == null) {
		  System.out.println("Empty node");
		  return;
	  }
	  while(temp!=null) {
		  System.out.println(temp.data);
		  temp = temp.prev;
	  }
	  
  }
  public void delete(int data) {
	  Node temp = head,prevNode = null,nextNode = null;
	  if(temp != null && temp.data == data) {
		  head = temp.next;
		  if(temp.next == null) {
			 tail = temp.prev;
		  }else {
			  head.prev = null;
		  }
		  return;
	  }
	  while(temp != null && temp.data != data) {
		  temp = temp.next;
		  nextNode = temp.next;
		  prevNode = temp.prev;
	  }
	  if(temp == null) {
		  return;
	  }
	  if(temp == tail) {
		  tail = temp.prev;
		  tail.next = null;
		  return;
	  }
	  System.out.println("prevNode Value:"+prevNode.data);
	  System.out.println("nextNode value:"+nextNode.data);
	  System.out.println("temp value:"+temp.data);
	  nextNode.prev = temp.prev;
	  prevNode.next = temp.next;
  }
  public void insertAfter(int nextTo,int data) {
	  //System.out.println("insertAfter called");
	  Node newNode = new Node(data);
	  Node temp = head,nextNode = null;
	  while(temp != null && temp.data != nextTo) {
		  temp = temp.next;
		  if(temp == null)return;
		  nextNode = temp.next;
	  }
	  if(temp == null) {
		  return;
	  }
	  if(temp == head) {
		  nextNode = temp.next;
	  }
	  if(temp == tail) {
		  tail.next = newNode;
		  newNode.prev = tail;
		  tail = newNode;
		  return;
	  }
	  System.out.println("temp value : "+temp.data);
	  System.out.println("newNode value : "+newNode.data);
	  System.out.println("nextNode value : "+nextNode.data);
	  temp.next = newNode;
	  newNode.next = nextNode;
	  newNode.prev = temp;
	  nextNode.prev = newNode;
  }
  public void insertBefore(int beforeTo,int data) {
	  //System.out.println("insertAfter called");
	  Node newNode = new Node(data);
	  Node temp = tail,prevNode = null;
	  while(temp != null && temp.data != beforeTo) {
		  temp = temp.prev;
		  if(temp == null)return;
		  prevNode = temp.prev;
	  }
	  if(temp == null) {
		  return;
	  }
	  if(temp == head) {
		  head.prev = newNode;
		  newNode.next = head;
		  head = newNode;
		  return;
	  }
	  if(temp == tail) {
		  prevNode = temp.prev;
	  }
//	  System.out.println("temp value : "+temp.data);
//	  System.out.println("prevNode value : "+prevNode.data);
//	  System.out.println("newNode value : "+newNode.data);
      newNode.prev = prevNode;
	  newNode.next = temp;
      prevNode.next= newNode;
      temp.prev = newNode;
  }
public static void main(String[] args) {
	DLinkedList list = new DLinkedList();
//	list.addNode(10);
//	list.addNode(20);
//	list.addNode(30);
//	list.addNode(40);
	list.delete(40);
	list.insertAfter(10, 100);
	list.insertBefore(10, 101);
	System.out.println("Displaying forward list : ");
	list.displayForward();
	System.out.println("Displaying backward list: ");
	list.displayBackward();	
	
}
}
