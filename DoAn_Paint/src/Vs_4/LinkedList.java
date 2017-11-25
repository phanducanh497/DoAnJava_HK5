package Vs_4;

import java.util.ArrayList;

public class LinkedList<T> {

	private int numberOfNode=0;
	private ListNode<T> front=null;
	
	
	public boolean isEmpty() {
		return (this.front==null);
	}
	
	public void makeEmpty() {
		this.front=null;
		this.numberOfNode=0;
	}
	
	public int size() {
		return this.numberOfNode;
	}
	
	//add node
	public void addFront(T element) {
		this.front=new ListNode<T>(element,front);
		this.numberOfNode++;
	}
	
	public T peek() {
		if(isEmpty())
			return null;
		return front.getData();
	}
	
	//@SuppressWarnings("unchecked")
	public T removeFront() {
		T tempData;
		
		if(isEmpty())
			return null;
		
		tempData=front.getData();
		this.front=front.getNext();
		this.numberOfNode--;
		return tempData;
	}
	
	public void removeEnd(T element) {
		ListNode<T> node=front;
		while(node.getNext()!=null) {
			node=node.getNext();
		}
		node.setNext(new ListNode<T>((T)element,null));
	}
	
	public ArrayList<T> getArray(){
		ArrayList<T> shapeArray=new ArrayList<T>();
		
		ListNode<T> node=front;
		while(node!=null) {
			shapeArray.add(node.getData());
			node=node.getNext();
		}
		
		return shapeArray;
	}
	
	
}
