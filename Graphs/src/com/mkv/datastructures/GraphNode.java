package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.List;

class GraphNode<T> {
	private T data;
	private int index;
	private List<GraphNode<T>> neighbors;
	private boolean isVisited;
	private GraphNode<T> parent;

	private GraphNode() {

	}

	GraphNode(T data, int index) {
		this.data = data;
		this.index = index;
		isVisited = false;
		neighbors = new ArrayList<>();
	}

	T getData() {
		return data;
	}

	private void setData(T data) {
		this.data = data;
	}

	int getIndex() {
		return index;
	}

	private void setIndex(int index) {
		this.index = index;
	}

	List<GraphNode<T>> getNeighbors() {
		return neighbors;
	}

	private void setNeighbors(List<GraphNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	boolean isVisited() {
		return isVisited;
	}

	void setVisited(boolean visited) {
		isVisited = visited;
	}

	GraphNode<T> getParent() {
		return parent;
	}

	void setParent(GraphNode<T> parent) {
		this.parent = parent;
	}

	@Override
	protected Object clone() {
		GraphNode<T> cloneGraph = new GraphNode<>();
		cloneGraph.setData(this.data);
		cloneGraph.setIndex(this.index);
		cloneGraph.setNeighbors(this.neighbors);
		cloneGraph.setVisited(this.isVisited);
		cloneGraph.setParent(this.parent);
		return cloneGraph;
	}
}
