package com.sss.algo;
class LinkedList{
	int i;
	LinkedList next;
	
}

public class List {
 	
	LinkedList head;
	private int size=0;
	
	public List(){
		head = new LinkedList();
	}
	
	LinkedList getNode(int i){
		LinkedList node = new LinkedList();
		node.i = i;
		return node;
	}
	
	int add(int i){
		LinkedList temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next =getNode(i);
		size++;
		return 1;
	}
	// size 2 3
	int add(int i,int pos){
		
		if(pos < 0){
			pos = 0;
		}
		if(pos > size ){
			pos = size;
		}
		
		LinkedList node = getNode(i); 
		LinkedList temp =head;
		for(int j=0;j<pos;j++){
			temp = temp.next;
		}
		LinkedList temp1 = temp.next;
		temp.next = node;
		node.next = temp1;
		size++;
		return 1;
	}

	int remove(){
		if(size==0){
			System.out.println("List empty. Can't delete any item");
			return -1;
		}
		LinkedList temp = head;
		for(;temp.next.next!=null;temp=temp.next);
		System.out.println("Element "+temp.next.i+" deleted");
		temp.next = null;
		size--;
		return 1;
	}
	
	int remove(int pos){
		if(size==0){
			System.out.println("List empty. Can't delete any item");
			return -1;
		}
		if(pos < 0){
			pos = 0;
		}
		
		if(pos >= size ){
			pos = size-1;
		}
		LinkedList temp =head;
		for(int j=0;j<pos;j++){
			temp = temp.next;
		}
		// head 11 22
		System.out.println("Element "+temp.next.i+" deleted");
		temp.next = temp.next.next;
		size--;
		return 1;
	}
	
	int get(int index){
		if(size==0){
			System.out.println("List empty");
			return -1;
		}
		if(index >= size || index < 0){
			System.out.println("Improper index "+index);
			return -1;
		}
		LinkedList temp = head;
		for(int j=0; j<=index; j++){
			temp = temp.next;
		}
		System.out.println("Data at index "+index+" is "+temp.i);
		return temp.i;
	}
	
	int getSize(){
		return size;
	}
	
	void display(){
		if(head.next == null){
			System.out.println("List is empty");
			return;
		}
		System.out.println("List Size:"+size);
		System.out.println("List data");
		for(LinkedList temp=head.next;temp!=null;temp=temp.next){
			System.out.println(temp.i);
		}
	}
	
	public static void main(String args[]){
		List list = new List();
		list.add(2);
		list.add(5,-3);
		list.add(6,0);
		list.add(7,10);
		list.add(12,2);
		list.add(15);
		list.display();
		list.get(-1);
		list.get(0);
		list.get(4);
		list.get(5);
		list.get(6);
		list.remove(6);
		list.remove(0);
		list.remove(23);
		list.remove(-12);
		list.display();
	}

}
