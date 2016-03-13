package com.asheesh.Graphs;

import com.asheesh.Queues.*;

public class BFS{
	int [] visited;
	Graph G;
	public BFS(Graph graph){
		this.G = graph;
	}
	public void bfsSearch(){
		visited = new int [G.V];
		for(int i =0 ; i < G.V ; i++){
			if(visited[i] == 0){
				visited[i]= 1;
				bfsImplementation(i);
			}
		}
	}
	
	public void bfsImplementation(int i){
		Queue q = new Queue(G.V);
		q.enQueue(i);
		while(!q.isQueueEmpty()){
			int u = q.deQueue();
			
			System.out.print(" " + u);
			for(int j = 0 ; j < G.V ; j++){
				if(G.AdjMat[u][j] == 1 && (visited[j] == 0) ){
					q.enQueue(j);
					visited[j] = 1;
				}
			}
		}
	}
}