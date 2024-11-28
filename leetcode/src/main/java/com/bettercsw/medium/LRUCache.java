package com.bettercsw.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author csw
 * @date 2020/11/27 15:31
 */
public class LRUCache {

    private int capacity;

    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.moveToHead(node);
        } else {
            if (map.size() >= capacity) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLastNode();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);
        }

    }

    public Integer get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<Integer, Integer> node = map.get(key);

        doubleLinkedList.moveToHead(node);

        return node.value;
    }


    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.prev = this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;

        }

        /**
         * 将节点添加到头部
         *
         * @param node
         */
        public void addHead(Node<K, V> node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        /**
         * 删除节点
         *
         * @param node
         */
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        public Node<K, V> getLastNode() {
            return tail.prev;
        }

        public void moveToHead(Node<K, V> node) {
            this.removeNode(node);
            this.addHead(node);
        }
    }


}
