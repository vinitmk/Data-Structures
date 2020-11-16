package com.mkv.datastructures.avltree;

class AVLTreeNode<T> {

	private T data;
	private int height;
	AVLTreeNode<T> left;
	AVLTreeNode<T> right;

	AVLTreeNode(T data) {
		this.data = data;
		this.height = 0;
	}

	T getData() {
		return data;
	}

	int getHeight() {
		return height;
	}

	void setData(T data) {
		this.data = data;
	}

	void setHeight(int height) {
		this.height = height;
	}
}
