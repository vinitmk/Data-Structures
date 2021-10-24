package com.mkv.datastructures.narytree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode {

	public int data;
	public List<NaryTreeNode> children;

	public NaryTreeNode (int data) {
		this.data = data;
		this.children = new ArrayList<>();
	}

	public NaryTreeNode(int data, List<NaryTreeNode> children) {
		this.data = data;
		this.children = children;
	}

	int getData() {
		return data;
	}

	void setData(int data) {
		this.data = data;
	}

	List<NaryTreeNode> getChildren() {
		return children;
	}

	void setChildren(List<NaryTreeNode> children) {
		this.children = children;
	}
}
