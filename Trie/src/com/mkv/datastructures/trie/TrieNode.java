package com.mkv.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

	private Map<Character, TrieNode> children;
	private boolean endOfString;

	TrieNode() {
		children = new HashMap<>();
		endOfString = false;
	}
}
