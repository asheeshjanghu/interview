package com.asheesh.Problems.Recursion;

public class TowerOfHanoi{
	int n;
	int [] arr;
	
	public static void main(String [] args){
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.initialize();
	}
	
	public void initialize(){
		int [] array = { 1, 2, 3 , 4, 5};
		n = array.length;
		arr = new int[n];
		for(int i =0 ; i < n ; i++){
			arr[i] = array[i];
		}
		move(arr,0,n,'A','C','B');
	}
	
	public void move(int[] array,int start, int end, char from, char dest, char aux){
		if(end -start == 0){
			return;
		}else if(end - start == 1){
			System.out.println(" Move " + array[start] + " from " + from + " to " + dest);
		}else{
			move(array,start,end-1,from,aux,dest);
			move(array,end-1,end,from,dest,aux);
			move(array,start,end-1,aux,dest,from);
		}
		
	}
	
}