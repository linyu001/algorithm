package com;
//����ʵ�ֶ���
public class Myqueue {
	private int []array;
	private int front;//��ͷ�±�
	private int rear;//��β�±�

	public Myqueue(int size){
		this.array=new int [size];
	}
	
	/**
	 * ���
	 * @param element ���Ԫ��
	 */
	public void enQueue(int element){
		if((rear+1)%array.length==front){
			System.out.println("�����������޷����");
		}
		array[rear]=element;
		rear=(rear+1)%array.length;
	}
	
	/**
	 * ����
	 * @return ���س���ֵ
	 */
	public int deQueue(){
		if(front==rear){
			System.out.println("�����ѿ�");
		}
		int element=array[front];
		front=(front+1)%array.length;
		return element;
	}
	/**
	 * �������
	 */
	public void output(){
		for (int i = front; i !=rear;i=(i+1)%array.length) {
			System.out.println(array[i]);
		}
	}
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		Myqueue queue=new Myqueue(4);
		queue.enQueue(1);//���
		queue.enQueue(2);//���
		queue.enQueue(3);//���
		queue.deQueue();//���ӣ���ʱ��ͷ�±��޸�
		queue.enQueue(2);//���
		queue.output();
		
		
	}
}
