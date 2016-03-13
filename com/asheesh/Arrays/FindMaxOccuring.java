package com.asheesh.Arrays;

import java.util.*;


public class FindMaxOccuring{
	
	
// program to find the maximum occuring element in an array in O(n) time using O(n) space 
	public int findMaxOccuringElementWithHashTable(int []array){
		int max = 0;
		int index = 0;
		Map<Integer,Integer> arrayMap = new HashMap<>();
		for(int i = 0 ; i < array.length ; i++){
			Integer x = arrayMap.get(array[i]);
			if(x != null){
				x++;
				arrayMap.put(array[i], x);	
				if(x >= max){
					max = x;
					index = i;
				}
			}else{
				arrayMap.put(array[i], 1);
			}
		}
		return array[index];
	}
	
	
	
// program to find the maximum occuring element in an array in O(n) time using O(1) space and elements range from 0 to k
// approach is to increment every A[A[i]%k] element by k 
// example arr = {2, 3, 3, 5 , 3, 4, 1, 7} here k=8 and n = 8
// resultant array {2, 11, 11, 29, 11, 12, 1, 15} we got this by arr[arr[0] %k } + k --> arr[2%8] + 8 = arr[2] + 8 = 3 +8 =11
// similarly for i = 1 in our array 3 is occuring --> arr[arr[1] % 8] +8 = arr[3 % 8] + 8 = 5 + 8 = 13;
//  similarly for i = 2 in our array 3 is occuring --> arr[arr[2] % 8] +8 = arr[3 % 8] + 8 = 13 + 8 = 21; and so on

	public int findMaxOccuringElement(int []array){
		System.out.println(" array = " + Arrays.toString(array));
		int max = 0;
		for(int i = 0 ; i < array.length ; i++){
			max = max>array[i]?max:array[i];
		}
		int k = max + 1;
		for(int i =0 ; i < array.length ; i++){
			array[array[i] %k] = array[array[i] %k] + k;
		}
		System.out.println(" array = " + Arrays.toString(array));
		max =0;
		int index =0;
		for(int i = 0 ; i < array.length ; i++){
			if(max<= array[i]){
				max = array[i];
				index = i;
			}
		}
		
		// to get back original array
		for(int i = 0 ; i < array.length ; i++){
			array[array[i] % k] = array[array[i] % k] - k;
		}
		System.out.println(" array = " + Arrays.toString(array) + "\n");
		
		return index;
	}
	
	
	public void findMaxoccuringElementTool(){
		int [] arr1 = {1,2,2,1,3,2};
		int [] arr2 = {2,4,3,3,2,3};
		int [] arr3 = { 4, 3, 4, 4, 2, 5};
		int [] arr4 = {2, 2, 2,3,3,1,4,0};
		
		FindMaxOccuring ms = new FindMaxOccuring();
		int x1 = ms.findMaxOccuringElement(arr1);
		int x2 = ms.findMaxOccuringElement(arr2);
		int x3 = ms.findMaxOccuringElement(arr3);
		int x4 = ms.findMaxOccuringElement(arr4);
		
		System.out.println(" x1 = " + x1);
		System.out.println(" x2 = " + x2);
		System.out.println(" x3 = " + x3);
		System.out.println(" x4 = " + x4);
	}
}