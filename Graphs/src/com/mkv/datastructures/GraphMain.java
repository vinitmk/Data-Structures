package com.mkv.datastructures;

public class GraphMain {

	public static void main(String[] args) {
		int size = 10;
		BFSTraversal<String> adjList = new BFSTraversal<>();

		for(int i = 0; i < size; i++)
			adjList.createGraphNodes("V"+i, i);

		adjList.addUndirectedEdge(0,1);
		adjList.addUndirectedEdge(0,3);
		adjList.addUndirectedEdge(1,2);
		adjList.addUndirectedEdge(1,4);
		adjList.addUndirectedEdge(2,5);
		adjList.addUndirectedEdge(2,9);
		adjList.addUndirectedEdge(3,6);
		adjList.addUndirectedEdge(4,7);
		adjList.addUndirectedEdge(5,8);
		adjList.addUndirectedEdge(6,7);
		adjList.addUndirectedEdge(7,8);
		adjList.addUndirectedEdge(8,9);

		adjList.bfsTraversal();
	}
}
