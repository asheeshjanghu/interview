package com.asheesh.Stacks;

public class Stack{
	public int top;
	public int size;
	public int [] S;
	
	public Stack(int size){
		this.top = -1;
		this.size = size;
		S = new int [this.size];
	}
	
	public int top(){
		return this.top;
	}
	
	public void push(int data){
		if(isStackFull() == 1){
			System.out.println("Stack is full therefore cannot push");
			return;
		}else{
			this.top++;
			this.S[this.top] = data;
		}
	}
	
	public int pop(){
		if(isStackEmpty() == 1){
			System.out.println("Stack is empty therefore cannot pop");
			return -1;
		}else{
			int data = this.S[top];
			this.top--;
			return data;
		}
	}
	
	public int isStackEmpty(){
		if(this.top == -1){
			return 1;
		}
		return 0;
	}
	
	public int isStackFull(){
		if(this.top == this.size){
			return 1;
		}
		return 0;
	}
	
	public void utilityMethod(){
		int [] arr = {1,3,4,6,2};
		for(int i =0 ; i < arr.length ; i++){
			push(arr[i]);
		}
		printStack();
		System.out.println(" popping " + pop());
		printStack();
	}
	
	public void printStack(){
		int i = top;
		while(i>-1){
			System.out.print(" "+ S[i]);
			i--;
		}
		System.out.println();
	}
	
}