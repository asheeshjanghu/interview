package com.asheesh.Queues;

public class Queue{

	int front , rear , capacity;
	int [] arrayQueue;
	boolean dynamic = false;
	
	public Queue(int capacity){
		this.capacity = capacity;
		arrayQueue = new int[capacity];
		front = -1;
		rear = -1;
	}
	
	public Queue(int capacity, boolean dynamic){
		this.capacity = capacity;
		arrayQueue = new int[capacity];
		front = -1;
		rear = -1;
		if(dynamic){
			this.dynamic = dynamic;
		}
	}
	
	public boolean enQueue(int data){
		//check if there is space to enqueue
		if(isQueueFull()){
			if(!dynamic)
				return false;
			reSizeQueue();
		}
		rear = (rear + 1)%capacity;
		arrayQueue[rear] = data;
		if(front == -1){
			front = rear;
		}
		return true;
	}
	
	public int deQueue(){
		if(isQueueEmpty()){
			//System.out.println("Queue empty in dequwuw");
			return -11;
		}
		int data = arrayQueue[front];
		if(front == rear){
			front = -1;
			rear = -1;
		}else{
			front = (front + 1)%capacity;
		}
		
		//System.out.println("front and rear are =  " + front + "  " + rear);
		
		return data;
	}
	
	public boolean isQueueEmpty(){
		if(front == -1){
			//System.out.println("Queue is empty");
			return true;
		}
		return false;
	}
	
	public boolean isQueueFull(){
		
		
		if((rear + 1)%capacity == front){
			if(dynamic){
				reSizeQueue();
				return false;
			}
			return true;
		}
		return false;
	}
	
	public void reSizeQueue(){
		int [] tempArray = new int [capacity];
		System.out.println("Resixing queue from " + capacity + " to  " + capacity * 2);
		for(int i = 0 ; i < capacity ; i++){
			tempArray[i] = arrayQueue[i];
		}
		
		arrayQueue = new int[2 * capacity];
		
		if(front > rear){
			for(int i = front ; i < capacity ; i++){
				arrayQueue[i] =  tempArray[i];
			}
			for(int i = 0 ; i <= rear ; i++){
				arrayQueue[capacity + i] =  tempArray[i];
			}
			rear = capacity + rear ;
		}else{
			for(int i= 0 ; i < capacity ; i++){
				arrayQueue[i] = tempArray[i];
			}
		}
		
		capacity = capacity * 2;
	}
	
	public void printQueue(){
		if(isQueueEmpty()){
			System.out.print("Queue is empty");
		}
		if(front <= rear){
			for(int i = front ; i<= rear ; i++ ){
				System.out.print(" " + arrayQueue[i]);
			}
		}else{
			for(int i = front ; i< capacity; i++ ){
				System.out.print(" " + arrayQueue[i]);
			}
			for(int i = 0 ; i<= rear; i++ ){
				System.out.print(" " + arrayQueue[i]);
			}
		}
		System.out.println("");
	}
	
	
}