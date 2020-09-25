package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.List;

class GraphNode<T> {
	private T data;
	private int index;
	private List<GraphNode> neighbors;
	private boolean isVisited;

	GraphNode(T data, int index) {
		this.data = data;
		this.index = index;
		isVisited = false;
		neighbors = new ArrayList<>();
	}
}
