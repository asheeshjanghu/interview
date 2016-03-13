package com.asheesh.Sort;

public class MergeSort{
	
	public void mergeSort(int [] arr){
		mergeSort(arr,0,arr.length-1);
	}
	
	public void mergeSort(int [] arr , int left , int right){
		if(left<right){
			int mid = (left + right)/2;
			mergeSort(arr,left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr,left,mid+1,right);
		}
	}
	
	public void merge(int [] arr, int left, int mid, int right){	
		int size = right - left + 1;
		int left_counter = left;
		int mid_counter = mid;
		int [] temp = new int[size];
		int j = 0;
		
		while(left_counter < mid && mid_counter <= right){
			if(arr[left_counter] <= arr[mid_counter]){
				temp[j] = arr[left_counter];
				left_counter++;
			}else{
				temp[j] = arr[mid_counter];
				mid_counter++;
			}
			j++;
		}
		
		while(left_counter < mid){
			temp[j] = arr[left_counter];
			left_counter++;
			j++;
		}
		
		while(mid_counter <= right){
			temp[j] = arr[mid_counter];
			mid_counter++;
			j++;
		}
		
		for(int i = 0 ; i<size ; i++){
			arr[left + i] = temp[i];
		}
		
	}
}