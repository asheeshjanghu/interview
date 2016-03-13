package com.asheesh.PriorityQueues;

import java.lang.Math.*;

public class PriorityQueue{
	int capacity;
	int [] heapArray;
	int count;
	int heapType;  // 0 for min and 1 for max
	
	public PriorityQueue(int cap, int type){
		this.capacity = cap;
		this.heapType = type;
		count = 0;
		heapArray = new int [capacity];
	}
	
	public void insert(int data){	
		if(count < capacity){
			heapArray[count] = data;
			count++;
			upHeapify();
		}
	}
	
	public int getMin(){
		return heapArray[0];
	}
	
	public int deleteMin(){
		if(count == 0){
			System.out.println(" Heap empty");
		}
		if(count == 1){
			return heapArray[0];
		}
		
		int data = heapArray[0];
		heapArray[0] =  heapArray[count-1];
		count--;
		int left , right, min;
		int pos = 0;
		
		
		while((2*pos + 1) < count){
			left = 2 * pos + 1;
			right = 2 * pos + 2;
			min = pos;
			if(heapArray[pos] > heapArray[left]){
				min = left;
			}
			if(right < count && heapArray[min] > heapArray[right]){
				min = right;
			}
			if(min == pos)
				break;
			
			int temp = heapArray[pos];
			heapArray[pos] = heapArray[min];
			heapArray[min] = temp;
			pos = min;
		}
		return data;
	}
	
	public int deleteMax(){
		if(count == 0){
			System.out.println(" Heap empty");
		}
		if(count == 1){
			return heapArray[0];
		}
		
		int data = heapArray[0];
		heapArray[0] =  heapArray[count-1];
		int left , right, max;
		int pos = 0;
		
		while((2*pos + 2) < count){
			left = 2 * pos + 1;
			right = 2 * pos + 2;
			max = pos;
			if(heapArray[pos] < heapArray[left]){
				max = left;
			}
			if(heapArray[max] < heapArray[right]){
				max = right;
			}
			
			heapArray[pos] = heapArray[max];
			pos = max;
		}
		
		return data;
	}
	
	
	
	public void PercolateDownMin(){
		if(count > 1){
			
		}
	}
	
	
	public void PercolateDownMax(){
		
	}
	
	public void upHeapify(){
		if(heapType == 0){
			PercolateUpMin(count - 1);
		}else{
			PercolateUpMax(count - 1);
		}
	}
	
	public void PercolateUpMin(int pos){
		int parent = ((pos - 1)/ 2);
		if(pos == 0 || heapArray[pos] > heapArray[parent]){
			return;
		}else {
			if(heapArray[pos] < heapArray[parent]){
				int temp = heapArray[pos];
				heapArray[pos] = heapArray[parent];
				heapArray[parent] = temp;
				PercolateUpMin(parent);
			}
		}
	}
	
	public void PercolateUpMax(int pos){
		
	}
	
	public void printPQ(){
		for(int i = 0 ; i < count ; i++){
			System.out.print(" " + heapArray[i]);
		}
	}
}