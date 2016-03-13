package com.asheesh.LinkLists;


// this program is not working and is not right
// in java create seperate linklists to solve this
public class LinkListQuickSort{
	
	LinkList ll;
	Node head;
	
	
	
	public void initialize(){
		ll = new LinkList();
		ll.utilityMethod();
		head = ll.getHead();
		head = qsort(head,null);
		ll.printList(head);
	}
	
	public Node qsort(Node first, Node last){
		Node lesHead = null, lesTail = null;
		Node eqHead = null, eqTail = null;
		Node larHead = null, larTail = null;
		Node current = first;
		if(current == null){
			return current;
		}
		int pivot = current.data;
		Append(current, eqHead, eqTail);
		current = current.next;
		
		while(current != null){
			if(current.data < pivot){
				Append(current,lesHead,lesTail);
			}else if(current.data > pivot){
				Append(current,larHead,larTail);
			}else{
				Append(current,eqHead,eqTail);
			}
			current = current.next;
		}
		qsort(lesHead,lesTail);
		qsort(larHead,larTail);
		join(lesHead,lesTail,eqHead,eqTail);
		join(lesHead,eqTail,larHead,larTail);
		return lesHead;
	}
	
	Node Append(Node present, Node head){
		Node tail= present;
		if(head == null){
			head = present;
		}else{
			
			tail.next = current;
			tail = tail.next;
		}
		tail.next = null;
		return head;
	}

	void join(Node start1, Node end1, Node start2, Node end2){
		if(end1 != null && start2 != null){
			end1.next = start2;
		}
	}
}