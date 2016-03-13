package com.asheesh.RunFolder;

import com.asheesh.Graphs.*;
import com.asheesh.LinkLists.*;
import com.asheesh.Trees.*;
import com.asheesh.Sort.*;
import com.asheesh.PriorityQueues.*;
import com.asheesh.Queues.*;
import com.asheesh.Arrays.*;
import com.asheesh.Stacks.*;

import java.util.Arrays;

public class RunClass{
	
	public static void main(String [] args){		
		RunClass runObj = new RunClass();
		
		Stack stack = new Stack(10);
		stack.utilityMethod();
		
		
		// LinkList ll = new LinkList();
		// ll.utilityMethod();
		// ReverseLinkList rll = new ReverseLinkList();
		// Node head = rll.reverseRecursive(ll.getHead());
		// ll.printList(head);
		
		//PriorityQueue1 pq = new PriorityQueue1();
		//pq.utilityMethod();
		
		//LinkListQuickSort llms = new LinkListQuickSort();
		//llms.initialize();
		
		//FindMaxOccuring fmo = new FindMaxOccuring();
		//fmo.findMaxoccuringElementTool();
		
		
	}
	
	public void bfsMethod(){
		CreateGraph cgObj = new CreateGraph();
		Graph G = cgObj.createFunc();
		BFS bfsObj = new BFS(G);
		bfsObj.bfsSearch();
	}
	
	public void dfsMethod(){
		CreateGraph cgObj = new CreateGraph();
		Graph G = cgObj.createFunc();
		DFS dfsObj = new DFS(G);
		dfsObj.dfSearch();
	}
	
	public void topoSortMethod(){
		CreateGraph cgObj = new CreateGraph();
		Graph G = cgObj.createFunc();
		TopologicalSort topoObj = new TopologicalSort(G);
		topoObj.topologicalSortMethod();
	}
	
	public void makePriorityQueue(){
		// System.out.println("Enter capacity of Priority Queue");
		//InputStreamReader isr = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(isr);
		//String input = br.readLine();
		//int n = Integer.parseInt(input);
		PriorityQueue pq = new PriorityQueue(13, 0);
		pq.insert(8);
		pq.insert(5);
		pq.insert(1);
		pq.insert(32);
		pq.insert(10);
		pq.insert(2);
		pq.insert(4);
		pq.insert(23);
		pq.insert(3);
		pq.insert(6);
		pq.insert(9);
		pq.insert(7);
		pq.printPQ();
		
		int data = pq.deleteMin();
		System.out.println("\n Min data = " + data);
		
		pq.printPQ();
		
		data = pq.deleteMin();
		System.out.println("\n Min data = " + data);
		
		pq.printPQ();
	}
	
	public void makePQwithKV(){
		// System.out.println("Enter capacity of Priority Queue");
		//InputStreamReader isr = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(isr);
		//String input = br.readLine();
		//int n = Integer.parseInt(input);
		PQwithKV pq = new PQwithKV(13, 0);
		pq.insert(8,2);
		pq.insert(5,0);
		pq.insert(1,1);
		pq.insert(32,3);
		pq.insert(10,4);
		pq.insert(2,5);
		pq.insert(4,6);
		pq.insert(23,7);
		pq.insert(3,8);
		pq.insert(6,9);
		pq.insert(9,10);
		pq.insert(7,11);
		pq.printPQ();
		
		int []data = pq.deleteMin();
		System.out.println("\n Min data = " + data[0] + " index = " + data[1]);
		
		pq.printPQ();
		
		data = pq.deleteMin();
		System.out.println("\n Min data = " + data[0] + " index = " + data[1]);
		
		pq.printPQ();
	}
	
	public void avlTreeExample(){
		AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
        
        TreeTraversals tt = new TreeTraversals();
        tt.inOrder(root);
        System.out.println();
        tt.preOrder(root);
	}
	
	public void mergeSortTool(){
		int [] arr1 = {1};
		int [] arr2 = {2,4};
		int [] arr3 = { 43, 3, 45, 234, 2};
		int [] arr4 = {42, 23, 2,-23,23,32,3,23};
		
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr1);
		ms.mergeSort(arr2);
		ms.mergeSort(arr3);
		ms.mergeSort(arr4);
		
		System.out.println(" Sorted out put = " +Arrays.toString(arr1));
		System.out.println(" Sorted out put = " +Arrays.toString(arr2));
		System.out.println(" Sorted out put = " +Arrays.toString(arr3));
		System.out.println(" Sorted out put = " +Arrays.toString(arr4));
	}
	
	public void quickSortTool(){
		int [] arr1 = {1};
		int [] arr2 = {2,4};
		int [] arr3 = { 43, 3, 45, 234, 2};
		int [] arr4 = {42, 23, 2,-23,23,32,3,23};
		
		QuickSort ms = new QuickSort();
		ms.quickSort(arr1);
		ms.quickSort(arr2);
		ms.quickSort(arr3);
		ms.quickSort(arr4);
		
		System.out.println(" Sorted out put = " +Arrays.toString(arr1));
		System.out.println(" Sorted out put = " +Arrays.toString(arr2));
		System.out.println(" Sorted out put = " +Arrays.toString(arr3));
		System.out.println(" Sorted out put = " +Arrays.toString(arr4));
	}
	
}