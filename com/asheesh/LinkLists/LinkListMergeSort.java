package com.asheesh.LinkLists;


public class LinkListMergeSort {
	
	Node head;
	LinkList ll;
	Node middle;
	
	public LinkListMergeSort(){
		
	}
	
	public void initialize(){
		ll = new LinkList();
		ll.utilityMethod();
		//System.out.println("NOw will sort");
		head = ll.getHead();
		//System.out.println("head data = " + head.data);
		head = mergeSortLL(head);
		ll.printList(head);
	}
	
	public Node mergeSortLL(Node head){
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node b = getMiddleAndSplit(head);
		Node a = head;
		// System.out.println("a d = " + a.data);
		if(b==null){
			// System.out.println("b is null");
		}
		if(b != null){
			// System.out.println("b d = " + b.data);
			a = mergeSortLL(a);
			b = mergeSortLL(b);
		}
		head = merge(a,b);
		// System.out.println(" head = " + head.data);
		return head;
	}
	
	public Node merge(Node a, Node b){
		// System.out.println("merging  " + (a==null?100:a.data) + "   " + (b==null?100:b.data));
		if(a == null){
			return b;
		}else if(b == null){
			return a;
		}
		
		Node result = null;
		if(a.data <= b.data){
			result = a;
			result.next = merge(a.next, b);
		}else{
			result = b;
			result.next = merge(a, b.next);
		}
		// System.out.println("returning head =   " +result.data);
		return result;
	}
	
	public Node getMiddleAndSplit(Node head){
		if(head == null || head.next == null){
			return null;
		}
		
		Node slowPtr = head;
		Node fastPtr = head.next;
		
		while(fastPtr != null){
			fastPtr = fastPtr.next;
			if(fastPtr != null){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}
		Node nextListHead = slowPtr.next;
		slowPtr.next = null;
		
		return nextListHead;
	}
	
		
}