package com.asheesh.Graphs;

public class DFS{
	
	Graph G;
	int [] visited;
	
	public DFS(Graph graph){
		this.G = graph;
		visited = new int [G.V];
	}
	
	public void dfSearch(){
		System.out.println("\n Dfs Order: ");
		for(int i =0 ; i < G.V ; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				dfsImpl(i);
			}
		}
	}
	
	public void dfsImpl(int i){
		System.out.print(" " + i + " ");
		for(int j =0 ; j< G.V ; j++){
			if(G.AdjMat[i][j] == 1 && visited[j] == 0){
				visited[j] = 1;
				dfsImpl(j);
			}
		}
	}

}