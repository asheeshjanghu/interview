package com.asheesh.PriorityQueues;

import java.lang.Math.*;

public class PQwithKV{
	int capacity;
	int [][] heapArray;
	int count;
	int heapType;  // 0 for min and 1 for max
	
	public PQwithKV(int cap, int type){
		this.capacity = cap;
		this.heapType = type;
		count = 0;
		heapArray = new int [capacity][2];
	}
	
	public void insert(int data, int key){
		if(count < capacity){
			heapArray[count][0] = data;
			heapArray[count][1] = key;
			count++;
			upHeapify();
		}
	}
	public boolean isQueueEmpty(){
		if(count > 0)
			return false;
		return true;
	}
	
	public int[] getMin(){
		return heapArray[0];
	}
	
	public int[] deleteMin(){
		if(count == 0){
			System.out.println(" Heap empty");
		}
		if(count == 1){
			return heapArray[0];
		}
		
		int data = heapArray[0][0];
		int [] arr = heapArray[0];
		heapArray[0] =  heapArray[count-1];
		count--;
		int left , right, min;
		int pos = 0;
		
		
		while((2*pos + 1) < count){
			left = 2 * pos + 1;
			right = 2 * pos + 2;
			min = pos;
			if(heapArray[pos][0] > heapArray[left][0]){
				min = left;
			}
			if(right < count && heapArray[min][0] > heapArray[right][0]){
				min = right;
			}
			if(min == pos)
				break;
			
			int []temp = heapArray[pos];
			heapArray[pos] = heapArray[min];
			heapArray[min] = temp;
			pos = min;
		}
		return arr;
	}
	
	public int[] deleteMax(){
		if(count == 0){
			System.out.println(" Heap empty");
		}
		if(count == 1){
			return heapArray[0];
		}
		
		int data = heapArray[0][0];
		int [] arr = heapArray[0];
		heapArray[0][0] =  heapArray[count-1][0];
		int left , right, max;
		int pos = 0;
		
		while((2*pos + 2) < count){
			left = 2 * pos + 1;
			right = 2 * pos + 2;
			max = pos;
			if(heapArray[pos][0] < heapArray[left][0]){
				max = left;
			}
			if(heapArray[max][0] < heapArray[right][0]){
				max = right;
			}
			
			heapArray[pos][0] = heapArray[max][0];
			pos = max;
		}
		
		return arr;
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
		if(pos == 0 || heapArray[pos][0] > heapArray[parent][0]){
			return;
		}else {
			if(heapArray[pos][0] < heapArray[parent][0]){
				int []temp = heapArray[pos];
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
			System.out.print(" " + heapArray[i][0]);
		}
	}
}