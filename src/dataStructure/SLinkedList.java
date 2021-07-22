package dataStructure;

public class SLinkedList {
   class Node{
	   int data;
	   Node next;
	   Node(int data){
		   this.data = data;
	   }
   }
   public Node head = null;
   public Node tail = null;
   public void addNode(int data) {
	Node newNode = new Node(data);
	if(head == null) {
		head = newNode;
	}else {
		tail.next = newNode;
	}
	tail = newNode;
	//System.out.println("Node added");
}
   public void display() {
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
   public void delete(int data) {
	  Node temp = head,prev = null;
	  if(temp != null && temp.data == data) {
		  head = temp.next;
		  return;
	  }
	  while(temp != null && temp.data != data) {
		  prev = temp;
		  temp = temp.next;
	  }
	  if(temp == null) {
		  return;
	  }
	  if(temp == tail) {
		  tail = prev;
		  tail.next = null;
		  return;
	  }
	  //System.out.println("Previous value : "+prev.data);
	  //System.out.println("temp Value : "+temp.data);
	  prev.next = temp.next;
   }
   public void insertAfter(int nextTo, int data) {
	   Node newNode = new Node(data);
	   Node temp = head;
	   while(temp != null && temp.data != nextTo) {
		   temp = temp.next;
	   }
	   if(temp == null) {
		   return;
	   }if(temp == tail) {
		   tail.next = newNode;
		   tail = newNode;
		   return;
	   }
	   newNode.next = temp.next;
	   temp.next = newNode;
   }
   public void deleteAdjacentDuplies() {
	   Node current = head;
	   while(current != null) {
		   Node next = current.next;
		   while(next != null && current.data == next.data) {
			   next = next.next;
		   }
		   current.next = next;
//		   if(next == tail && current.data == next.data) {
//			   tail = current;
//			   tail.next = null;
//		   }
		   current = next;
	   }
   }
   public void deleteDuplicate() {
       Node current = head;
       Node next = head.next;
       while (next != null) {
           if (current.data == next.data) current.next = next.next;
           else current = next;
           next = next.next;
       }
   }

public static void main(String[] args) {
	SLinkedList list = new SLinkedList();
	list.addNode(10);
	list.addNode(10);
	list.addNode(30);
	list.addNode(30);
	list.addNode(30);
	list.addNode(30);
	list.addNode(30);
	list.addNode(20);
	list.addNode(30);
	list.addNode(30);
	list.addNode(220);
//	list.deleteDuplicate();
	list.deleteAdjacentDuplies();
//	list.addNode(40);
//	list.addNode(50);
//	list.delete(300);
	//list.insertAfter(50, 22);
	//list.insertAfter(00, 22);
	list.display();
}

}
