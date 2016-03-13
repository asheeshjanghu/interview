package com.asheesh.PriorityQueues;

import java.util.Arrays;

public class PriorityQueue1{
	
	public static int MIN_HEAP = 0;
	
	public int capacity;
	public int count;
	public int [] arr;
	int type;
	
	public PriorityQueue1(){}
	
	public void createHeap(int cap, int type){
		count = 0;
		capacity = cap;
		arr = new int [cap];
		this.type = type;
	}
	
	public void buildHeap(int [] array, int n){
		while(capacity < n){
			reSize();
		}
		for(int i = 0 ; i < n ; i++){
			arr[i] = array[i];
		}
		count = n;
		System.out.println(" original array = " + Arrays.toString(array));
		for(int i=((n-1)/2); i >=0 ; i--){
			System.out.println("inserting at " +i + " and element = " +arr[i]);
			percolateDown(i);
			System.out.println(" after array = " + Arrays.toString(arr));
		}
	}
	
	public void reSize(){
		capacity = capacity * 2;
	}
	
	public void percolateDown(int i){
		int l = leftChild(i);
		int r = rightChild(i);
		int min = i;
		System.out.println(" l = " +l + " r = " + r);
		if(l != -1 && arr[i] > arr[l]){
			min = l;
		}
		if(r != -1 && arr[min] > arr[r]){
			min = r;
		}
		if(min != i){
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			percolateDown(min);
		}
	}
	
	public void percolateUp(int i){
		int p = getParent(i);
		if(p > -1 && arr[i] < arr[p]){
			int temp = arr[p];
			arr[p] = arr[i];
			arr[i] = temp;
			percolateUp(p);
		}		
	}
	
	public void insert(int data){
		// add at the end and percolateUp at the parent
		count++;
		arr[count -1] = data;
		percolateUp(count-1);
	}
	
	public int deleteMin(){
		// move the last data at the top and then decrease the count and then percolateDown the top 
		int min = arr[0];
		arr[0] = arr[count-1];
		count--;
		percolateDown(0);
		return min;
	}
	
	public int getMin(){
		return arr[0];
	}
	public void delete(int data){
		// to delete any given item from heap ; takes O(n) time
		int i = search(data,0);
		if(i>-1){
			System.out.println(data + " fount at position = " + i);
			arr[i] = arr[count - 1];
			count--;
			percolateDown(i);
		}else{
			System.out.println(data + " is not present in heap");
		}
	}
	
	//preorder searching ; takes O(n)
	public int search(int data, int i){
		if(data == arr[i]){
			return i;
		}
		int l = leftChild(i);
		int r = rightChild(i);
		if(l != -1 && search(data,l) > -1){
			return l;
		}else if(r != -1 && search(data,r) > -1){
			return r;
		}else{
			return -1;
		}
	}
	
	public int getParent(int i){
		int p = ((i-1)/2);
		if(p>-1){
			return p;
		}
		return -1;
	}
	public int leftChild(int i){
		int left = 2*i + 1;
		if(left > count-1)
			return -1;
		return left;
	}
	
	public int rightChild(int i){
		int right = 2*i + 2;
		if(right > count-1)
			return -1;
		return right;
	}
	
	public void printHeap(){
		int c = 0;
		while(c < count){
			System.out.print("  " + arr[c]);
			c++;
		}
		System.out.println();
	}
	
	public void utilityMethod(){
		int [] array = {};
		//{10, 2, 5, 3 , 6 , 8,0, -2, 4};
		createHeap(array.length+ 2, MIN_HEAP);
		buildHeap(array,array.length);
		printHeap();
		delete(2);
		printHeap();
		insert(-4);
		printHeap();
	}
	
}