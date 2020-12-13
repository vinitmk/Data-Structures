package com.mkv.datastructures.hashtable;

import java.util.ArrayList;
import java.util.List;

class HashTable<K, V> {

	private List<HashNode<K, V>> arrayOfBuckets;

	private int numOfBuckets;

	private int size;

	HashTable() {
		arrayOfBuckets = new ArrayList<>();
		numOfBuckets = 10;
		size = 0;

		for(int i = 0; i < numOfBuckets; i++)
			arrayOfBuckets.add(null);

	}

	private int getBucketIndex(K key) {
		return key.hashCode() % numOfBuckets;
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}

	V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = arrayOfBuckets.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key))
				return head.value;
			head = head.next;
		}
		return null;
	}

	void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = arrayOfBuckets.get(bucketIndex);

		while(head != null) {
			if(head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = arrayOfBuckets.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<>(key, value);
		newNode.next = head;
		arrayOfBuckets.set(bucketIndex, newNode);
	}

	V remove(K k) {
		int bucketIndex = getBucketIndex(k);
		HashNode<K, V> head = arrayOfBuckets.get(bucketIndex);
		HashNode<K, V> prev = null;

		while(head != null) {
			if(head.key.equals(k))
				break;
			prev = head;
			head = head.next;
		}
		if(head == null)
			return null;

		size--;
		if(prev != null)
			prev.next = head.next;
		else
			arrayOfBuckets.set(bucketIndex, head.next);
		return head.value;
	}
}
