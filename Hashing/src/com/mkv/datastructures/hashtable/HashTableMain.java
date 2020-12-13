package com.mkv.datastructures.hashtable;

public class HashTableMain {

	public static void main(String[] args) {
		HashTable<String, Integer> hashTable = new HashTable<>();

		hashTable.add("this",1 );
		hashTable.add("coder",2 );
		hashTable.add("this",4 );
		hashTable.add("hi",5 );

		System.out.println(hashTable.size());
		System.out.println(hashTable.remove("this"));
		System.out.println(hashTable.remove("this"));
		System.out.println(hashTable.size());
		System.out.println(hashTable.isEmpty());
		System.out.println(hashTable.get("coder"));
	}
}
