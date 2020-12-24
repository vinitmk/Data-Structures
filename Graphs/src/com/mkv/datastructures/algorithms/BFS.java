package com.mkv.datastructures.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.mkv.datastructures.model.GraphNode;

public class BFS<T> {

	private List<GraphNode<T>> nodeList;

	public BFS() {
		nodeList = new ArrayList<>();
	}

	public List<GraphNode<T>> getNodeList() {
		return nodeList;
	}

	void setNodeList(List<GraphNode<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public void createGraphNodes(T data, int index) {
		nodeList.add(new GraphNode<>(data, index));
	}

	public void addUndirectedEdge(int s, int d) {
		GraphNode<T> firstNode = nodeList.get(s);
		GraphNode<T> secondNode = nodeList.get(d);
		firstNode.getNeighbors().add(secondNode);
		secondNode.getNeighbors().add(firstNode);
	}

	private void shortestPathBFS(GraphNode<T> node) {
		Queue<GraphNode<T>> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode<T> currentNode = queue.poll();
			currentNode.setVisited(true);
			System.out.print("Printing path for node "+currentNode.getIndex()+": ");
			printPath(currentNode);
			System.out.println();
			List<GraphNode<T>> neighbors = currentNode.getNeighbors();
			for(GraphNode<T> neighbor: neighbors)
				if(!neighbor.isVisited()) {
					queue.add(neighbor);
					neighbor.setVisited(true);
					neighbor.setParent(currentNode);
				}
		}

	}

	private void printPath(GraphNode<T> currentNode) {
		if(currentNode.getParent() != null)
			printPath(currentNode.getParent());
		System.out.print(currentNode.getIndex()+" ");
	}

	public void shortestPathBFSByIndex(int index) {
		shortestPathBFS(nodeList.get(index));
	}

}
