package com.asheesh.LinkLists;

public class ReverseLinkList{
	
	public Node reverseIterative(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node p,q,r;
			q = head;
			p = head.next;
			q.next = null;
			while(p != null){
				r = p.next;
				p.next = q;
				q = p;
				p = r;				
			}
			head = q;
			return head;
		}
	}
	
	public Node reverseRecursive(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node node = head.next;
			head.next = null;	
			Node revList = reverseRecursive(node);
			node.next = head;
			head.next = null;
			return revList;
		}
	}
	
}