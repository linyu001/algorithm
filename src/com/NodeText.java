package com;

public class NodeText {
	
	private Node head;//头节点
	private Node last;//尾节点
	private int size;//链表长度
	
	public void insert(int data,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("超出链表范围");
		}
		Node insertNode=new Node(data);
		if(size==0){
			//空链表
			head=insertNode;
			last=insertNode;
		}else if (index==0){
			//插入头部
			insertNode.next=head;
			head=insertNode;
		}else if (index==size){
			//插入尾部
			last.next=insertNode;
			last=insertNode;
		}else{
			//中间插入
			Node middle=get(index-1);
			insertNode.next=middle.next;
			middle.next=insertNode;
		}
		size++;
	}
	
	public void remove(int index){
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("超出链表范围");
		}
	     if (index==0){
			//删除头结点
	    	// removeNode=head;
	    	 head=head.next;    	 
		}else if (index==size){
			//删除尾节点
			Node preNode=get(size-1);
			preNode.next=null;
		}else{
			//删除中间节点
			Node preNode=get(index-1);
			Node nextNode=preNode.next.next;
			preNode.next=nextNode;
			
		}
		size--;
	}
	
	public Node get(int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("超出链表范围");
		}
		Node temp=head;
		for (int i = 0; i <index; i++) {
			temp=temp.next;
		}
		return temp;
	}
	public void output(){
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		NodeText text=new NodeText();
		text.insert(3, 0);
		text.insert(7, 1);
		text.insert(9, 2);
		text.insert(5, 3);
		text.remove(1);
		text.output();
		System.out.println();
	}
}

 class Node {
	int data;
	Node next;
	Node (int data){
		this.data=data;
	}

}
