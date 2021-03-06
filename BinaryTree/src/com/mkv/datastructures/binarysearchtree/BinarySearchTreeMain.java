package com.mkv.datastructures.binarysearchtree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import com.mkv.datastructures.common.IOHandler;

public class BinarySearchTreeMain implements IOHandler<Integer> {

	private BinarySearchTreeNode<Integer> root;

	@Override
	public void print() {
		System.out.println("Inorder traversal ");
		printInOrder(root);
		System.out.println("\nPreorder traversal ");
		printPreOrder(root);
		System.out.println("\nPostorder traversal ");
		printPostOrder(root);
		System.out.println("\nLevelorder traversal using Queue");
		printLevelOrderUsingQueue(root);
		System.out.println("\nLevelorder traversal using HashMap");
		Map<Integer, List<Integer>> nodesMap = new HashMap<>();
		printLevelOrderUsingHashMap(root, 1, nodesMap);
		for (int i = 1; i <= nodesMap.size(); i++){
			System.out.print(nodesMap.get(i) + "\t");
		}
		System.out.println("\nReverse Levelorder traversal");
		printReverseLevelOrder(root);
	}

	private void printReverseLevelOrder(BinarySearchTreeNode<Integer> root) {
		BinarySearchTreeNode treeNode;
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		Queue<BinarySearchTreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()){
			treeNode = queue.poll();
			if(null != treeNode)
				stack.push(treeNode);
			if(null != treeNode && null != treeNode.left)
				queue.add(treeNode.left);
			if(null != treeNode && null != treeNode.right)
				queue.add(treeNode.right);
		}
		while(!stack.empty())
			System.out.print(stack.pop().data + "\t");
	}

	// Print Level Order using HashMap. O(n) Time and Space Complexity
	private void printLevelOrderUsingHashMap(BinarySearchTreeNode<Integer> root, int level, Map<Integer, List<Integer>> nodeMap) {
		if(null != root){
			nodeMap.putIfAbsent(level, new ArrayList<>());
			nodeMap.get(level).add(root.data);
			printLevelOrderUsingHashMap(root.left, level+1, nodeMap);
			printLevelOrderUsingHashMap(root.right, level+1, nodeMap);
		}
	}

	// Print Level Order using Queue. O(n) Time and Space Complexity
	private void printLevelOrderUsingQueue(BinarySearchTreeNode<Integer> root) {
		BinarySearchTreeNode dataNode;
		Queue<BinarySearchTreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			dataNode = queue.poll();
			if(null != dataNode)
				System.out.print(dataNode.data + "\t");
			if(null != dataNode && null != dataNode.left)
				queue.add(dataNode.left);
			if(null != dataNode && null != dataNode.right)
				queue.add(dataNode.right);
		}
	}

	private void printPreOrder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			System.out.print(root.data + "\t");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	private void printPostOrder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + "\t");
		}
	}

	private void printInOrder(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			printInOrder(root.left);
			System.out.print(root.data + "\t");
			printInOrder(root.right);
		}
	}

	private void heightOfTree(){
		int heightOfBinarySearchTree = calculateHeight(root);
		System.out.print("\nHeight of Binary Search Tree is " + heightOfBinarySearchTree);
	}

	private int calculateHeight(BinarySearchTreeNode<Integer> root) {
		int rightSubTreeHeight, leftSubTreeHeight;
		if(root == null)
			return 0;
		else {
			leftSubTreeHeight = calculateHeight(root.left);
			// System.out.println(" root leftSubTreeHeight "+root.data+"\t"+leftSubTreeHeight);
			rightSubTreeHeight = calculateHeight(root.right);
			// System.out.println(" root rightSubTreeHeight "+root.data+"\t"+rightSubTreeHeight);
			return leftSubTreeHeight > rightSubTreeHeight ? ++leftSubTreeHeight : ++rightSubTreeHeight;
		}
	}

	@Override
	public void createDataStructure(Integer data) {
		root = createDataStructure(root, data);
	}

	private BinarySearchTreeNode<Integer> createDataStructure(BinarySearchTreeNode<Integer> root, Integer data) {
		if(null == root)
			return new BinarySearchTreeNode<>(data);
		else if (root.data > data)
			root.left = createDataStructure(root.left, data);
		else
			root.right = createDataStructure(root.right, data);
		return root;
	}

	private void sizeofTree() {
		int sizeOfBinaryTree = calculateSize(root);
		System.out.print("\nSize of tree is "+ sizeOfBinaryTree);
	}

	private int calculateSize(BinarySearchTreeNode<Integer> root) {
		if(null != root){
			return 1 + calculateSize(root.left) + calculateSize(root.right);
		}
		return 0;
	}

	private void searchInTree(int num) {
		boolean exists = searchNumInTree(root, num);
		System.out.println("\n Number "+num+" exists "+ exists);
	}

	private boolean searchNumInTree(BinarySearchTreeNode<Integer> root, int num) {
		if(root != null) {
			if(num == root.data)
				return true;
			if(num > root.data)
				return searchNumInTree(root.right, num);
			else
				return searchNumInTree(root.left, num);
		}
		return false;
	}

	private void checkBinarySearchTree() {
		boolean isBST = isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("\nIs Binary Search Tree "+isBST);
	}

	private boolean isBinarySearchTree(BinarySearchTreeNode<Integer> node, int minValue, int maxValue) {
		if(node == null)
			return true;
		if(node.data <= minValue || node.data >= maxValue)
			return false;
		return isBinarySearchTree(node.left, minValue, node.data) && isBinarySearchTree(node.right, node.data, maxValue);
	}

	public static void main(String[] args){

		Random num = new Random();
		BinarySearchTreeMain binarySearchTreeMain = new BinarySearchTreeMain();
		int findNum = num.nextInt(99);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input data for Linked List ");
//		int data;
//		while(scanner.hasNext()){
//			data = scanner.nextInt();
//			binarySearchTreeMain.createDataStructure(data);
//		}
		for(int i = 0; i < 10; i++){
			if(i == 9){
				binarySearchTreeMain.createDataStructure(findNum);
			}
			else
				binarySearchTreeMain.createDataStructure(num.nextInt(99));
		}
		binarySearchTreeMain.print();
		binarySearchTreeMain.heightOfTree();
		binarySearchTreeMain.sizeofTree();
		binarySearchTreeMain.searchInTree(findNum);
		binarySearchTreeMain.checkBinarySearchTree();
	}
}
