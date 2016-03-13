package com.asheesh.LinkLists;

import com.asheesh.Graphs.*;

public class LinkList{

	Node head;
	
	public Node insert(Node head , int data, int position){
		if(position < 0){
			//System.out.println("Position can not be negative");
			return null;
		}else if(head == null){
			//System.out.println("Position head = null");
			Node node = new Node();
			node.data =  data;
			node.next = null;
			this.head = node;
			return this.head;
		}else if(position == 0){
			//System.out.println("Position = 0");
			Node node = new Node();
			node.data =  data;
			node.next = head;
			this.head = node;
			return this.head;
		}else{
			//System.out.println("Position > 0 ");
			Node node = new Node();
			node.data =  data;
			this.head = head;	
			Node temp = head;
			Node prev = null;
			while(position > 0 && temp != null){
				prev = temp;
				temp = temp.next;
				position--;
			}
			prev.next = node;
			if(temp == null){
				node.next = null;
			}else if(position == 0){
				node.next = temp;
			}
			return this.head;
		}
	}
	
	public void removeNode(Node head , int data){
		if(head == null){
			return;
		}else{
			Node temp = head;
			Node prev;
			while(temp != null && temp.data != data){
				prev = temp;
				temp = temp.next;
			}
								
		}
	}
	
	public Node removeNodeAt(Node head , int position){
		if(head == null){
			return null;
		}else{
			Node temp = head;
			Node prev = head;
			while(temp != null && position !=0){
				prev = temp;
				temp = temp.next;
				position--;
			}
			if(temp != null){
				prev.next = temp.next;
			}else{
				prev.next = null;
			}
			return head;
		}
	}
	
	public Node getHead(){
		return this.head;
	}
	
	public Node getLast(){
		Node temp = head;
		Node prev = null;
		while(temp != null){
			prev = temp;
			temp = temp.next;
		}
		return temp;
	}
	
	public void printList(Node head){
		Node temp = head;
		System.out.println();
		while(temp != null){
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public Node getMiddle(Node head){
		Node slowPtr = null;
		Node fastPtr = null;
		if(head == null || head.next == null){
			slowPtr = head;
			fastPtr = null;
		}
		while(fastPtr != null){
			fastPtr = fastPtr.next;
			if(fastPtr != null){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}
		System.out.println(" Middle = " + slowPtr.data);
		return slowPtr.next;
	}

	public Node createLinkList(int []arr){
		Node head = null;
		for(int i = 0 ; i < arr.length ; i++){
			head = insert(head,arr[i],100);
		}
		return head;
	}
	
	public void utilityMethod(){
		int [] arr = {4,0,4,33, 7,88,1 , 2, 3, 4, 5,9};
		LinkList ll = new LinkList();
		Node head = ll.createLinkList(arr);
		ll.printList(head);
		this.head = head;
		
	}
}
