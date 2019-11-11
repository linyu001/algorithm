package com;

public class NodeText {
	
	private Node head;//ͷ�ڵ�
	private Node last;//β�ڵ�
	private int size;//������
	
	public void insert(int data,int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("��������Χ");
		}
		Node insertNode=new Node(data);
		if(size==0){
			//������
			head=insertNode;
			last=insertNode;
		}else if (index==0){
			//����ͷ��
			insertNode.next=head;
			head=insertNode;
		}else if (index==size){
			//����β��
			last.next=insertNode;
			last=insertNode;
		}else{
			//�м����
			Node middle=get(index-1);
			insertNode.next=middle.next;
			middle.next=insertNode;
		}
		size++;
	}
	
	public void remove(int index){
		if(index<0||index>=size){
			throw new IndexOutOfBoundsException("��������Χ");
		}
	     if (index==0){
			//ɾ��ͷ���
	    	// removeNode=head;
	    	 head=head.next;    	 
		}else if (index==size){
			//ɾ��β�ڵ�
			Node preNode=get(size-1);
			preNode.next=null;
		}else{
			//ɾ���м�ڵ�
			Node preNode=get(index-1);
			Node nextNode=preNode.next.next;
			preNode.next=nextNode;
			
		}
		size--;
	}
	
	public Node get(int index){
		if(index<0||index>size){
			throw new IndexOutOfBoundsException("��������Χ");
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
