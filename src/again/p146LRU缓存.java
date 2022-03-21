package again;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 使用 哈希表辅助 双向链表实现。
    class DLinkedNode {
        int key;
        int value;
        // 除了 key 和 value 之外，还要有一个前后节点
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
    // 使用一个 map 进行存储
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    // 当前大小
    private int size;
    // 容量
    private int capacity;
    // 头尾
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 从 map 中拿到数据
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 将 node 移动到头部
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 先进行查询，如果不存在，在进行操作
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);


            ++size;
            // 如果大小超出容量
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                // 从尾部剔除
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            // 如果已经存在，则进行修改值，然后移动到头部1
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        // head 是一个卫兵
        node.prev = head;
        node.next = head.next;
        //
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
