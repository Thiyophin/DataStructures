package dataStructure;

public class BinarySearchTree {
	// Make node data type using class and constructor
  static class Node{
	  int data;
	  Node left,right;
	  public Node(int item) {
		  data = item;
	  }
  }
  Node root; //root node
  //method to insert node to tree
  public void insert(int data) {
	  Node newNode = new Node(data);
	  Node currentNode = root;
	  if(currentNode == null) {
		  root = newNode;
		  return;
	  }
	  while(true) {
		  if(data < currentNode.data) {
			  if(currentNode.left == null) {
				  currentNode.left = newNode;
				  return;
			  }else {
				  currentNode = currentNode.left;
			  }
		  }else {
			  if(currentNode.right == null) {
				  currentNode.right = newNode;
				  return;
			  }else {
				  currentNode = currentNode.right;
			  }
		  }
	  }
  }
  // to print InOrder - left,root,right
  public void inOrder() {
	  if(root == null) {
		  System.out.println("Tree is empty");
		  return;
	  }
	  System.out.print("InOrder  : ");
	  inOrderHelper(root);
  }
  private void inOrderHelper(Node node) {
	  if(node != null) {
		  inOrderHelper(node.left);
		  System.out.print(node.data + " ");
		  inOrderHelper(node.right);
	  }
  }
  // to print preOrder - root,left,right
  public void preOrder() {
	  if(root == null) {
		  System.out.println("Tree is empty");
		  return;
	  }
	  System.out.print("PreOrder : ");
	  preOrderHelper(root);
  }
  private void preOrderHelper(Node node) {
	  if(node != null) {
		  System.out.print(node.data+ " ");
		  preOrderHelper(node.left);
		  preOrderHelper(node.right);
	  }
  }
  // to print postOrder - left,right,root
  public void postOrder() {
	  if(root == null) {
		  System.out.println("Tree is empty");
		  return;
	  }
	  System.out.print("PostOrder: ");
	  postOrderHelper(root);
  }
  private void postOrderHelper(Node node) {
	  if(node != null) {
		  postOrderHelper(node.left);
		  postOrderHelper(node.right);
		  System.out.print(node.data+ " ");
	  }
  }
  // Method to search a value is present in tree
  public boolean contains(int data) {
	  Node currentNode = root;
	  while(currentNode != null) {
		  if(data < currentNode.data) {
			  currentNode = currentNode.left;
		  }
		  else if(data > currentNode.data) {
			  currentNode = currentNode.right;
		  }
		  else {
			  return true;
		  }
	  }
	  return false;
  }
  //Method to delete a node in BST
  public void remove(int data) {
	  if(root == null) return;
	  removeHelpers(data,root,null);
  }
  //Recursive method which help to remove node
  public void removeHelpers(int data,Node currentNode,Node parentNode) {
	  while(currentNode != null) {
		  if(data < currentNode.data) {
			  parentNode = currentNode;
			  currentNode = currentNode.left;
		  }
		  else if(data > currentNode.data) {
			  parentNode = currentNode;
			  currentNode = currentNode.right;
		  }// else we found the data
		  else {
			  //case - 1 having remove node has two both children
			  if(currentNode.left != null && currentNode.right != null) {
				  //if two children in left and right are present, we have 
				  //to replace it with left side's largest value or right
				  //side's smallest value,here we are taking right side's smallest value.
				  currentNode.data = getMinValue(currentNode.right);
				  //now the deleting node gets replaced by smallest value.
				  //for delete the smallest value from there, we have call removeHelper again
				  removeHelpers(currentNode.data,currentNode.right,currentNode);
			  }// case -2 deleting node has only one child or no child at all.
			  else {
				  //subcase -1 (deleting node has parent node null - which means deleting node is root in the tree)
				  if(parentNode == null) {
					  //if deleting root node has only left child let's reference the root node to left and vice versa for right child
					  if(currentNode.left == null) {
						  root = currentNode.right;
					  }else {
						  root = currentNode.left;
					  }
				  }
				  //subcase -2(deleting node has a valid parent node)
				  else {
					  // Check if currentNode is present at left side of the parentNode 
					  // then we have connect parent's left to current's left(if right is null) or vice versa
					  if(parentNode.left == currentNode) {
						  if(currentNode.right == null) {
							  parentNode.left = currentNode.left;
						  }else {
							  parentNode.left = currentNode.right;
						  }
					  }else {
						  if(currentNode.right == null) {
							  parentNode.right = currentNode.left;
						  }else {
							  parentNode.right = currentNode.right;
						  }
					  }
				  }
			  }
			  break;
		  }
	  }
   }
	  //recursive method to find minimum value of right side's deleting node
	  public int getMinValue(Node currentNode) {
		  if(currentNode.left != null) {
			  return getMinValue(currentNode.left);
		  }else {
			  return currentNode.data;
		  }
	  }
	  // Method find the closest value for a number in tree
	  public int findClosese(int target) {
		  Node current = root;
		  int closest = current.data;
		  while(current != null) {
			  if(Math.abs(target - closest) > Math.abs(target - current.data)) {
				  closest = current.data;
			  }
			  if(target < current.data) {
				  current = current.left;
			  }
			  else if(target > current.data) {
				  current = current.right;
			  }else
				  break;
		  }
		  return closest;
	  }

public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	tree.insert(10);
	tree.insert(20);
	tree.insert(15);
	tree.insert(3);
	tree.insert(1);
	tree.insert(5);
	tree.insert(8);
	tree.insert(21);
	tree.insert(22);
	tree.insert(19);
	tree.remove(10);
	tree.inOrder();
	System.out.println();
	tree.preOrder();
	System.out.println();
	tree.postOrder();
	System.out.println();
	//System.out.println(tree.contains(21));
	System.out.println(tree.findClosese(18));
}
}
