package com.asheesh.Graphs;

import java.io.*;

public class AdjacencyListGraphImpl{

	
	public static void main(String []args){
		try{
		BufferedReader br;
		AdjacencyListGraphImpl alg = new AdjacencyListGraphImpl();
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of Vertices : ");
		String input;
		input = br.readLine();
		int n = Integer.parseInt(input);
		
		AdjGraphDS adjDs = new AdjGraphDS(n);
		
		System.out.println("Enter number of Edges now : ");
		int numberOfEdges = Integer.parseInt(br.readLine());
		System.out.println("Enter Edges now one at a time with space seperated : ");
		
		int u , v;
		String [] inputs;
		
		for(int i = 0 ; i < numberOfEdges ; i++){
			inputs = br.readLine().split("\\s+");
			u = Integer.parseInt(inputs[0]);
			v = Integer.parseInt(inputs[1]);
			adjDs.addNeighbor(u,v);
		}
		adjDs.printGraph();
		}catch(IOException ioe){
			System.out.println("Io exc");
		}
		
		
	}
	
}