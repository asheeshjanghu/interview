package com.asheesh.Graphs;

import java.util.*;

public class AdjGraphDS{
	
	Map<Integer , LinkedList<Integer>> adj;
	int numberOfNodes;
	
	public  AdjGraphDS(int  n){
		numberOfNodes = n;
		adj = new HashMap<Integer , LinkedList<Integer>>();
		
		for(int i = 0 ; i < numberOfNodes ; i++){
			adj.put(i, new LinkedList<Integer>());
		}
	}
	
	public void addNeighbor(int v1, int v2){
		adj.get(v1).add(v2);
		adj.get(v2).add(v1);
	}
	
	public LinkedList<Integer> getNeighbors(int v1){
		return adj.get(v1);
	}
	
	public void printGraph(){
		Iterator itr = adj.entrySet().iterator();
		LinkedList<Integer> linkedList;
		while(itr.hasNext()){
			Map.Entry<Integer, List<Integer>> pair = (Map.Entry)itr.next();
			int node = pair.getKey();
			linkedList = getNeighbors(node);
			System.out.print( node + "  "  );
			for(int neighbor : linkedList){
				System.out.print("  " + neighbor );
			}
			System.out.println();
			
		}
	}
}