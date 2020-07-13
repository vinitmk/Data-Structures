package com.mkv.datastructures.binarysearchtree;

class BinarySearchTreeNode<T> {

	T data;
	BinarySearchTreeNode<T> left;
	BinarySearchTreeNode<T> right;

	BinarySearchTreeNode(T data) {
		this.data = data;
	}
}