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
	 * 创建二叉树
	 * 
	 * @param inputlist
	 *            /输入序列
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
	 * 前序遍历
	 * 
	 * @param node
	 *            二叉树节点
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
	 * 中序遍历
	 * 
	 * @param node
	 *            二叉树节点
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
	 * 后序遍历
	 * 
	 * @param node
	 *            二叉树节点
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
	      * 树的结构
	      *                      1
	      *                  2       3
	      *               4    5   6
	      */
		TreeNode node = createBinaryTree(inputlist);
		System.out.println("前序遍历：");
		preOrderTraveal(node);
		System.out.println("中序遍历：");
		inOrderTraveal(node);
		System.out.println("后序遍历：");
		postOrderTraveal(node);
	}

}
