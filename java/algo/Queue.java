package com.sss.algo;
class QueueNode{
	int i;
	QueueNode next;
}

public class Queue {
	
	QueueNode head;
	int size;
	
	public Queue(){
		head = new QueueNode();
		size =0;
	}
	
	public QueueNode getNode(int i){
		QueueNode node = new QueueNode();
		node.i = i;
		return node;
	}
	
	public int enQueue(int i){
		QueueNode temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = getNode(i);
		size++;
		return 1;
	}
	
	public int deQueue(){
		if(size ==0){
			System.out.println("Queue empty.Can't deQueue element");
			return -1;
		}
		QueueNode temp = head;
		int data = temp.next.i;
		temp.next = temp.next.next;
		System.out.println("Removed "+data+" from queue");
		size--;
		return data;
	}
	
	public int getSize(){
		return size;
	}
	
	public void display(){
		if(head.next == null){
			System.out.println("Queue is empty. Nothing to display");
			return;
		}
		System.out.println("Queue Size:"+size);
		System.out.println("Queue data");
		for(QueueNode temp=head.next;temp!=null;temp=temp.next){
			System.out.println(temp.i);
		}
	}
	
	public static void main(String args[]) throws Exception{
		Queue queue = new Queue();
		queue.deQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.deQueue();
		queue.enQueue(40);
		queue.enQueue(50);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.display();
	}
}
