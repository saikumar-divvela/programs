package com.sss.algo;
class StackNode{
	int i;
	StackNode next;
}

public class Stack {
	
	StackNode head;
	int size;
	
	public Stack(){
		head = new StackNode();
		size =0;
	}
	
	public StackNode getNode(int i){
		StackNode node = new StackNode();
		node.i = i;
		return node;
	}
	
	public int push(int i){
		StackNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = getNode(i);
		size++;
		return 1;
	}
	
	public int pop(){
		if(size ==0){
			System.out.println("Stack empty.Can't pop element");
			return -1;
		}
		StackNode temp = head;
		while(temp.next.next!=null){
			temp = temp.next;
		}
		int data = temp.next.i;
		temp.next = temp.next.next;
		System.out.println("Removed "+data+" from stack");
		size--;
		return data;
	}
	
	public int getSize(){
		return size;
	}
	
	public void display(){
		if(head.next == null){
			System.out.println("Stack is empty. Nothing to display");
			return;
		}
		System.out.println("Stack Size:"+size);
		System.out.println("Stack data");
		for(StackNode temp=head.next;temp!=null;temp=temp.next){
			System.out.println(temp.i);
		}
	}
	
	public static void main(String args[]) throws Exception{
		Stack stack = new Stack();
		stack.pop();
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.push(40);
		stack.push(50);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.display();
	}
}
