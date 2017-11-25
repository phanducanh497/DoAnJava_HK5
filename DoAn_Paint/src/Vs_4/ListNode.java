package Vs_4;

public class ListNode<T>  {

	private T data;
	private ListNode next;
	
	public ListNode(T nodeData) {
		this(nodeData,null);
	}

	public ListNode(T nodeData, ListNode nodeNext ) {
		this.data=nodeData;
		this.next=nodeNext;
	}
	
	public T getData() {
		return this.data;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
	public void setData(T newData) {
		this.data=newData;
	}
	
	public void setNext(ListNode newNext) {
		this.next=newNext;
	}
}
