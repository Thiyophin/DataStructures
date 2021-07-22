package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graph<T> {
  // HashMap key as vertex(Integer) and value as edge(Integer in arrayList or LinkedList)
   private Map<T,List<T>>map = new HashMap<>();
   
  // Method to create vertex of each data.
   private void addVertex(T data) {
	   // insert key as data and value an empty arrayList(also we can use LinkedList).
	   map.put(data, new ArrayList<>());
   }
   // Method to insert data to HashMap
   public void insert(T vertex,T edge,boolean isBidirectional) {
	   // Check if vertex is present in hashMap as key.
	   if(!map.containsKey(vertex)) {
		   addVertex(vertex);
	   }
	   // Check if edge is present in hashMap as key.
	   if(!map.containsKey(edge)) {
		   addVertex(edge);
	   }
	   // even if graph is unidirectional we can put vertex as key and value as edge.
	   map.get(vertex).add(edge);
	   // Checks if graph bidirectional
	   if(isBidirectional) {
	   // If it is bidirectional we have add vertex value to the key edge.
		   map.get(edge).add(vertex);
	   }
   }
   // Method to display HashMap
   public void display() {
	   //for loop to loop over HashMap.
//	   for(Integer X : map.keySet()) {
//		   System.out.print(X+" : ");
//		   for(Integer Y : map.get(X)) {
//			   System.out.print(Y+" ");
//		   }   System.out.println();
//	   }
	   for(Entry<T, List<T>> entry : map.entrySet()) {
		   System.out.println(entry.getKey()+" : "+entry.getValue());
	   }
   }
 public static void main(String[] args) {
	Graph<String> graph = new Graph<>();
	graph.insert("Thipi", "Theo", true);
	graph.insert("Theo", "Ansal", true);
	graph.insert("Ansal", "Thipi", false);
	graph.display();
}
}
