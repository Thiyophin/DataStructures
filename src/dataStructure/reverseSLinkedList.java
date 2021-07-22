package dataStructure;

public class reverseSLinkedList {
    class Node{
	   int data;
	   Node next;
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
		   newNode.next = null;
	   }
	   tail = newNode;
   }
   public void displayList() {
	   Node temp = head;
	   if(head == null) {
		   System.out.println("Empty");
		   return;
	   }
	   while(temp != null) {
		   System.out.println(temp.data);
		   temp = temp.next;
	   }
	   System.out.println("tail data : "+tail.data);
   }
   public void reverseList() {
	  if(head == null)return;
	  Node prevNode = head;
	  head = head.next;
	  Node currentNode = head;
	  prevNode.next = null;
	  tail = prevNode;
	  while(head != null) {
		  head = head.next;
		  currentNode.next = prevNode;
		  prevNode = currentNode;
		  currentNode = head;
	  }
	  head = prevNode;
   }
public static void main(String[] args) {
	reverseSLinkedList list = new reverseSLinkedList();
	list.addNode(1);
	list.addNode(2);
	list.addNode(3);
	list.addNode(4);
	list.addNode(5);
	list.addNode(6);
	//list.reverseList();
	list.displayList();
}
}
