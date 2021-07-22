package dataStructure;

public class StacK {
   static class Node{
	   int data;
	   Node next;
	  public Node(int data){
		   this.data = data;
	   }
   }
   Node top;
   void push(int data) {
	   Node newNode = new Node(data);
	   if(top == null) {
		   top = newNode;
		   return;
	   }
	   newNode.next = top;
	   top = newNode;
   }
   void pop() {
	   if(top == null) {
		   System.out.println("Stack UnderFlow");
		   return;
	   }
	   top = top.next;
   }
   void display() {
	   Node temp = top;
	   if(top == null) {
		   System.out.println("Empty");
		   return;
	   }
	   while(temp != null) {
		   System.out.println(temp.data);
		   temp = temp.next;
	   }
	   
   }
public static void main(String[] args) {
	StacK stack = new StacK();
	stack.push(10);
	stack.push(100);
	stack.push(1000);
	//stack.pop();
	stack.display();
}  
}
