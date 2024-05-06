// Source: https://leetcode.com/problems/lru-cache/
// https://www.youtube.com/watch?v=Hi5obC_CwIU
package LinkedList_Pkg;

import java.util.HashMap;

class ListNode_LRU{
    int key;
    int val;
    ListNode_LRU prev;
    ListNode_LRU next;

    public ListNode_LRU(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRU_Cache {
    int capacity;
    HashMap<Integer, ListNode_LRU> map;
    ListNode_LRU head;
    ListNode_LRU tail;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode_LRU(-1, -1);
        tail = new ListNode_LRU(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        ListNode_LRU node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode_LRU oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode_LRU node = new ListNode_LRU(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > capacity){
            ListNode_LRU nodeToRemove = head.next;
            remove(nodeToRemove);
            map.remove(nodeToRemove.key);
        }
    }

    public void add(ListNode_LRU node){
        ListNode_LRU prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode_LRU node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */