package com.asheesh.Sort;

public class QuickSort{
	
	public void quickSort(int [] arr){
		quickSort(arr,0,arr.length-1);
	}
	
	public void quickSort(int [] arr, int left , int right){
		if(left < right){
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	//{ 43, 3, 45, 234, 2};
	
	public int partition(int [] arr, int low , int high){
		int pivot_item = arr[low];
		int left = low;
		int right = high;
		
		while(left < right){
			while(arr[left] <= pivot_item && left < right){
				left++;
			}
			
			while(arr[right] > pivot_item){
				right--;
			}
			
			if(left < right){
				swap(arr,left,right);	
			}
		}
		arr[low] = arr[right];
		arr[right] = pivot_item;
		
		return right;
		
	}
	
	public void swap(int []arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}