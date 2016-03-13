package com.asheesh.Sort;

import com.asheesh.Graphs.*;
import com.asheesh.Queues.*;

public class TopologicalSort{
	Graph G;
	int [] indegree;
	
	public TopologicalSort(Graph graph){
		this.G = graph;
		indegree = new int[G.V];
	}
	
	public void topologicalSortMethod(){
		for(int i = 0 ; i < G.V ; i++){
			for(int j = 0 ; j < G.V ; j++){
				if(G.AdjMat[i][j] == 1){
					indegree[j]++;
				}
			}
		}
		
		for(int i = 0 ; i < G.V ; i++){
			System.out.println(" Indegree of "+ i + " =  " + indegree[i]);
		}
		topologicalSortImpl();
		
	}
	
	public void topologicalSortImpl(){
		Queue q = new Queue(G.V);
		
		for(int i = 0 ; i < G.V ; i++){
			if(indegree[i] == 0){
				q.enQueue(i);
			}
		}
		
		System.out.print(" \n Topological Sort");
		while(!q.isQueueEmpty()){
			int u = q.deQueue();
			System.out.print(" " + u + " ");
			for(int j = 0 ; j < G.V ; j++){
				if(G.AdjMat[u][j] == 1 && indegree[j] != 0){
					indegree[j]--;
					if(indegree[j] == 0){
						q.enQueue(j);
					}
				}
			}
		}
	}
}