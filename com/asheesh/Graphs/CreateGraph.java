package com.asheesh.Graphs;

import java.io.*;
	
public class CreateGraph {
	
	BufferedReader br;
	public Graph createFunc(){
		InputStreamReader isr = new InputStreamReader(System.in);
		
		CreateGraph cg = new CreateGraph();
		cg.br = new BufferedReader(isr);
		Graph G = cg.createGraphFunc();
		return G;
		
	}
	
	public Graph createGraphFunc() {
		Graph G = new Graph();
		System.out.println("Enter Number of Vertices and Edges");
		try{
			String input = br.readLine();
		String []diffInputs = input.split("\\s+");
		int len = diffInputs.length;
		if(len > 0){
			G.V = Integer.parseInt(diffInputs[0]);
			if(len == 2){
				G.E = Integer.parseInt(diffInputs[1]);
			}
			else{
				System.out.println("Enter number of Edges");
				G.E = Integer.parseInt(br.readLine());
			}
		}
		
		
		System.out.println("Enter edges : ");
		
		G.AdjMat = new int [G.V][G.V];
		
		for(int i=0 ; i<G.V ; i++){
			for(int j=0 ; j<G.V ; j++){
				G.AdjMat[i][j] = 0;
			}
		}
		
		for(int i =0 ; i<G.E ; i++){
			String [] edges = br.readLine().split("\\s+");
			if(edges.length != 2){
				i--;
				continue;
			}
			int u = Integer.parseInt(edges[0]);
			int v = Integer.parseInt(edges[1]);
			G.AdjMat[u][v] =  1;
			//G.AdjMat[v][u] =  1;
		}
		}catch(IOException ioe){
			System.out.println("IO Exception occured");	
		}
		
		printGraph(G);
		
		return G;
		
		
		
	}
	
	public void printGraph(Graph G){
		System.out.print("  ");
		for(int i=0 ; i<G.V ; i++){
			System.out.print(" " + i);
		}
		System.out.println();
		
		for(int i=0 ; i<G.V ; i++){
			System.out.print(" " + i);
			for(int j=0 ; j<G.V ; j++){
				System.out.print(" " + G.AdjMat[i][j]);
			}
			System.out.println();
		}
	}
}