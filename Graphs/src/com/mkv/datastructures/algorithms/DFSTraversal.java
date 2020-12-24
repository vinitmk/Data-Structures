package com.mkv.datastructures.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.mkv.datastructures.model.GraphNode;

public class DFSTraversal<T> {

	private List<GraphNode<T>> nodeList;

	public DFSTraversal() {
		nodeList = new ArrayList<>();
	}

	public void createGraphNodes(T data, int index) {
		nodeList.add(new GraphNode<>(data,index));
	}

	public void addUndirectedEdge(int i, int j) {
		GraphNode<T> first = nodeList.get(i);
		GraphNode<T> second = nodeList.get(j);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}

	public void dfsTraversal() {
		for (GraphNode<T> n: nodeList) {
			if(!n.isVisited()) {
				//dfsInterative(n);
				dfsRecursive(n);
			}
		}
	}

	private void dfsInterative(GraphNode<T> n) {
		Stack<GraphNode<T>> stack = new Stack<>();
		List<GraphNode<T>> neighbors;
		GraphNode<T> temp;
		stack.push(n);
		while(!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(temp.getData());
			temp.setVisited(true);
			neighbors = temp.getNeighbors();
			for (GraphNode<T> t:neighbors ) {
				if(!t.isVisited()) {
					t.setVisited(true);
					stack.push(t);
				}
			}
		}
	}

	private void dfsRecursive(GraphNode<T> node) {
		node.setVisited(true);
		System.out.println(node.getData());
		for (GraphNode<T> n: node.getNeighbors()) {
			if(!n.isVisited()) {
				dfsRecursive(n);
			}
		}
	}
}
