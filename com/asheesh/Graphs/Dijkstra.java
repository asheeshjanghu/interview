package com.asheesh.Graphs;

import com.asheesh.PriorityQueues.*;

public class Dijkstra{
	Graph G;
	int [][] infoArray;  // 0 index for distance and index 1 for vertex from where it is reached
	int source;
	PQwithKV q ;
	
	public Dijkstra(Graph graph, int u){
		this.G = graph;
		infoArray = new int [G.V] [2];
		source = u;
		for(int i = 0 ; i < G.V ; i++){
			infoArray[i][0] = -1;
		}
		infoArray[source][0] = 0;
		infoArray[source][1] = source;
	}
	
	public void findShortestPath(){
		q = new PQwithKV(G.V,0);
		q.insert(0,source);
		while(!q.isQueueEmpty()){
			int [] arr = q.deleteMin();
			int u = arr[1];
			int d = arr[0];
			
			// for all adjcent vertices update the distance
			for(int i = 0 ; i < G.V ; i++){
				if(G.AdjMat[u][i] > 0){
					// if never visited before
					if(infoArray[i][0] == -1){
						infoArray[i][0] = infoArray[u][0] + G.AdjMat[u][i];
						infoArray[i][1] = u;
						q.insert(infoArray[i][0] , i);
					}
					// if visited but had greater distance
					if(infoArray[i][0] > -1 && infoArray[i][0] > infoArray[u][0] + G.AdjMat[u][i]){
						infoArray[i][0] = infoArray[u][0] + G.AdjMat[u][i];
						infoArray[i][1] = u;
					}
				}
			}
			
			
			
			
		}
	}
}