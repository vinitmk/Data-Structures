package com.mkv.datastructures.sorting.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
	private T data;
	private int index;
	private List<GraphNode<T>> neighbors;
	private boolean isVisited;
	private GraphNode<T> parent;

	private GraphNode() {

	}

	public GraphNode(T data, int index) {
		this.data = data;
		this.index = index;
		isVisited = false;
		neighbors = new ArrayList<>();
	}

	public T getData() {
		return data;
	}

	private void setData(T data) {
		this.data = data;
	}

	public int getIndex() {
		return index;
	}

	private void setIndex(int index) {
		this.index = index;
	}

	public List<GraphNode<T>> getNeighbors() {
		return neighbors;
	}

	private void setNeighbors(List<GraphNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}

	public GraphNode<T> getParent() {
		return parent;
	}

	public void setParent(GraphNode<T> parent) {
		this.parent = parent;
	}

	@Override
	public Object clone() {
		GraphNode<T> cloneGraph = new GraphNode<>();
		cloneGraph.setData(this.data);
		cloneGraph.setIndex(this.index);
		cloneGraph.setNeighbors(this.neighbors);
		cloneGraph.setVisited(this.isVisited);
		cloneGraph.setParent(this.parent);
		return cloneGraph;
	}
}
