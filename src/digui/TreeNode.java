package digui;

import java.util.Arrays;
import java.util.LinkedList;

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
	 * ǰ�����
	 * 
	 * @param node
	 *            �������ڵ�
	 */
	public static void preOrderTraveal(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrderTraveal(node.leftchild);
		preOrderTraveal(node.rightchild);

	}

	/**
	 * �������
	 * 
	 * @param node
	 *            �������ڵ�
	 */
	public static void inOrderTraveal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraveal(node.leftchild);
		System.out.println(node.data);
		inOrderTraveal(node.rightchild);

	}

	/**
	 * �������
	 * 
	 * @param node
	 *            �������ڵ�
	 */
	public static void postOrderTraveal(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraveal(node.leftchild);
		postOrderTraveal(node.rightchild);
		System.out.println(node.data);

	}

	public static void main(String[] args) {
		LinkedList<Integer> inputlist = new LinkedList<Integer>(Arrays
				.asList(new Integer[] { 1, 2, 4, null, null, 5, null, null, 3,
						6 }));
	     /**
	      * ���Ľṹ
	      *                      1
	      *                  2       3
	      *               4    5   6
	      */
		TreeNode node = createBinaryTree(inputlist);
		System.out.println("ǰ�������");
		preOrderTraveal(node);
		System.out.println("���������");
		inOrderTraveal(node);
		System.out.println("���������");
		postOrderTraveal(node);
	}

}
