package com.mkv.datastructures;

public class GraphDFSMain {

	public static void main(String[] args) {
		int size = 10;
		DFSTraversal<String> dfsMain = new DFSTraversal<>();

		for(int i = 0; i < size; i++)
			dfsMain.createGraphNodes("V"+i, i);

		dfsMain.addUndirectedEdge(0,1);
		dfsMain.addUndirectedEdge(0,3);
		dfsMain.addUndirectedEdge(1,2);
		dfsMain.addUndirectedEdge(1,4);
		dfsMain.addUndirectedEdge(2,5);
		dfsMain.addUndirectedEdge(2,9);
		dfsMain.addUndirectedEdge(3,6);
		dfsMain.addUndirectedEdge(4,7);
		dfsMain.addUndirectedEdge(5,8);
		dfsMain.addUndirectedEdge(6,7);
		dfsMain.addUndirectedEdge(7,8);
		dfsMain.addUndirectedEdge(8,9);

		dfsMain.dfsTraversal();
	}
}
