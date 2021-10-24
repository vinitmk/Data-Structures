package com.mkv.datastructures.narytree;

import java.util.*;

public class NaryTreeMain {


	private List<List<Integer>> bfs(NaryTreeNode root) {
		if(root == null)
			return new ArrayList<>();

		List<List<Integer>> result = new ArrayList<>();
		Queue<NaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelNodes = new ArrayList<>();
			for(int i = 0 ; i < size; i++) {
				NaryTreeNode parent = queue.poll();
				if(parent != null) {
					levelNodes.add(parent.getData());
					for(NaryTreeNode child: parent.getChildren()) queue.add(child);
				}
			}
			result.add(levelNodes);
		}
		return result;
	}

	private void dfs(NaryTreeNode root, List<Integer> level, List<List<Integer>> result) {
		if(root != null) {
			level.add(root.getData());
			if(root.getChildren().size() == 0) {
				result.add(new ArrayList<>(level));
			} else {
				for(NaryTreeNode child: root.getChildren()) {
					dfs(child, level, result);
					level.remove(level.size()-1);
				}
			}

		}
	}


	public static void main(String[] args) {

		// Creating N-ary Tree
		NaryTreeNode root = new NaryTreeNode(1);
		root.getChildren().add(new NaryTreeNode(2));
		root.getChildren().add(new NaryTreeNode(3));
		root.getChildren().add(new NaryTreeNode(4));
		root.getChildren().get(1).getChildren().add(new NaryTreeNode(5));
		root.getChildren().get(1).getChildren().add(new NaryTreeNode(6));

		NaryTreeMain main = new NaryTreeMain();
		List<List<Integer>> bfsResult = main.bfs(root);
		for(List<Integer> level: bfsResult) {
			System.out.println(level);
		}

		List<List<Integer>> dfsResult = new ArrayList<>();
		main.dfs(root, new ArrayList<>(), dfsResult);
		for(List<Integer> level: dfsResult) {
			System.out.println(level);
		}
	}
}
