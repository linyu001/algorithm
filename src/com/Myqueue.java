package com;
//数组实现队列
public class Myqueue {
	private int []array;
	private int front;//队头下标
	private int rear;//队尾下标

	public Myqueue(int size){
		this.array=new int [size];
	}
	
	/**
	 * 入队
	 * @param element 入队元素
	 */
	public void enQueue(int element){
		if((rear+1)%array.length==front){
			System.out.println("队列已满，无法入队");
		}
		array[rear]=element;
		rear=(rear+1)%array.length;
	}
	
	/**
	 * 出队
	 * @return 返回出队值
	 */
	public int deQueue(){
		if(front==rear){
			System.out.println("队列已空");
		}
		int element=array[front];
		front=(front+1)%array.length;
		return element;
	}
	/**
	 * 输出队列
	 */
	public void output(){
		for (int i = front; i !=rear;i=(i+1)%array.length) {
			System.out.println(array[i]);
		}
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Myqueue queue=new Myqueue(4);
		queue.enQueue(1);//入队
		queue.enQueue(2);//入队
		queue.enQueue(3);//入队
		queue.deQueue();//出队，此时队头下标修改
		queue.enQueue(2);//入队
		queue.output();
		
		
	}
}
