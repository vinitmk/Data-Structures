package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.List;

class GraphNode<T> {
	private T data;
	private int index;
	private List<GraphNode<T>> neighbors;

	GraphNode<T> getParent() {
		return parent;
	}

	void setParent(GraphNode<T> parent) {
		this.parent = parent;
	}

	private boolean isVisited;
	private GraphNode<T> parent;

	GraphNode(T data, int index) {
		this.data = data;
		this.index = index;
		isVisited = false;
		neighbors = new ArrayList<>();
	}

	T getData() {
		return data;
	}

	void setData(T data) {
		this.data = data;
	}

	int getIndex() {
		return index;
	}

	void setIndex(int index) {
		this.index = index;
	}

	List<GraphNode<T>> getNeighbors() {
		return neighbors;
	}

	void setNeighbors(List<GraphNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	boolean isVisited() {
		return isVisited;
	}

	void setVisited(boolean visited) {
		isVisited = visited;
	}
}
