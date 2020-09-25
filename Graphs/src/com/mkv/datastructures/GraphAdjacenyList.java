package com.mkv.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class GraphAdjacenyList<T> {

	private List<GraphNode<T>> nodeList;

	GraphAdjacenyList() {
		nodeList = new ArrayList<>();
	}

	void createGraphNodes(T data, int index) {
		nodeList.add(new GraphNode<>(data, index));
	}

	void addUndirectedEdge(int i, int j) {
		GraphNode<T> firstNode = nodeList.get(i);
		GraphNode<T> secondNode = nodeList.get(j);
		firstNode.getNeighbors().add(secondNode);
		secondNode.getNeighbors().add(firstNode);
	}

	void bfsTraversal() {
		for(GraphNode node: nodeList)
			if(!node.isVisited())
				bfs(node);
			
	}

	private void bfs(GraphNode node) {
		GraphNode temp;
		List<GraphNode> neighbors;
		Queue<GraphNode> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			temp.setVisited(true);
			System.out.println(temp.getData());
			neighbors = temp.getNeighbors();
			for(GraphNode n: neighbors)
				if(!n.isVisited()) {
					n.setVisited(true);
					queue.add(n);
				}
		}
	}

}
