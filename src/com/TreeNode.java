package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	int data;
	TreeNode leftchild;
	TreeNode rightchild;

	TreeNode(int data) {
		this.data = data;
	}

	/**
	 * ����������
	 * 
	 * @param inputlist
	 *            /��������
	 * @return
	 */
	public static TreeNode createBinaryTree(LinkedList<Integer> inputlist) {
		TreeNode node = null;
		if (inputlist == null || inputlist.isEmpty()) {
			return null;
		}
		Integer data = inputlist.removeFirst();
		if (data != null) {
			node = new TreeNode(data);
			node.leftchild = createBinaryTree(inputlist);
			node.rightchild = createBinaryTree(inputlist);
		}
		return node;
	}

	/**
	 * ������� (���з�ʽʵ��)
	 * @param root
	 */
	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			System.out.println(node.data);
			if(node.leftchild!=null){
				queue.offer(node.leftchild);
			}
			if(node.rightchild!=null){
				queue.offer(node.rightchild);
			}
		}

	}

	public static void main(String[] args) {
		LinkedList<Integer> inputlist = new LinkedList<Integer>(Arrays
				.asList(new Integer[] { 1, 2, 4, null, null, 5, null, null, 3,
						6,null }));
		  /**
	      * ���Ľṹ
	      *                      1
	      *                  2       3
	      *               4    5   6
	      */               
		TreeNode node = createBinaryTree(inputlist);
		System.out.println("���������");
		levelOrderTraversal(node);
	}
}
