package dataStructure;

import java.util.HashMap;
import java.util.Map;

public class Tries {
 // create class Trie_node with Hash_map
	static class TrieNode{
		// map is a interface and children is our node of hash_map(key as character and value as TriesNode type) object
		Map<Character,TrieNode> children = new HashMap<>();
	}
	// declare root as TrieNode type ,we declare like this also(TrieNode root;) 
	TrieNode root = new TrieNode();
	// Constructor of TrieNode to pass Str when object is made to Tries Class
	char endSymbol = '*';
	public Tries(String str) {
		populateSuffixTrie(str);
	}
	// method to pass Index and string to TrieNodes
	private void populateSuffixTrie(String str) {
		for(int i=0; i<str.length(); i++) {
			insertSubStringAt(i,str);
		}
	}
	//method to insert suffix format string to TrieNodes
	private void insertSubStringAt(int index,String str) {
		// Reference giving to root after each string gets stored.
		TrieNode node = root;
		// for loop to iterate over the string with the index passes
		for(int i=index; i<str.length() ; i++) {
			char letter = str.charAt(i);
			// Check if this character present in node,if not put the character as key and newNode as value to node
			if(!node.children.containsKey(letter)) {
				TrieNode newNode = new TrieNode();
				node.children.put(letter, newNode);
			}
			// reference Node to newNode by passing key to get() in Hashmap
			node = node.children.get(letter);
		}
		//end of for_loop add endSymbol and null to node
		node.children.put(endSymbol, null);
	}
	// method to search a string in tries
	public boolean contains(String str) {
		if(root == null)return false;
		// let's loop through the tries
		TrieNode node = root;
		for(int i=0; i<str.length(); i++) {
			char letter = str.charAt(i);
			if(!node.children.containsKey(letter)) {
				System.out.println("1");
				return false;
			}
			System.out.println("2");
			node = node.children.get(letter);
		}
		return node.children.containsKey(endSymbol);
	}
	//method to delete a string in tries
	public void delete(String str) {
		if(root == null)return;
		TrieNode node = root;
		for(int i=0; i<str.length(); i++) {
			char letter = str.charAt(i);
			if(!node.children.containsKey(letter))return;
			node = node.children.get(letter);
		}
		if(node.children.containsKey(endSymbol)) {
			TrieNode removeNode = root,temp;
			for(int i=0; i<str.length(); i++) {
				System.out.println("Size:"+removeNode.children.size());
				char letter = str.charAt(i);
				temp = removeNode.children.get(letter);
				removeNode.children.remove(letter);
				removeNode = temp;
			}
	   }
	}
  public static void main(String[] args) {
	Tries tries = new Tries("hello");
	tries.delete("lo");
    //System.out.println(tries.contains("llo"));
}
}
