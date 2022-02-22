/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

/**
 *
 * @author libing
 * @version $Id: p138_复制带随机指针的链表.java, v 0.1 2022年02月22日 下午12:07 zt Exp $
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    /**
     * 第一个步骤就是将用 Map 进行保存，每次深度遍历
     * 第二种方式是时间换空间，就直接用替代方法
     * @param head
     * @return
     */



    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // [1,2,3,4]

        Node itr = head;
        // 设置一个next的copy
        while (itr != null) {
            Node next = itr.next;
            Node newExt = new Node(itr.val);
            itr.next = newExt;
            newExt.next = next;
            itr = next;
        }

        // [old 1] [new 1] [old 2][new 2] 这样排列
        // 设置new队列的 random

        itr = head;

        while (itr != null) {

            Node random = itr.random;
            if (random != null) {
                itr.next.random = random.next;
                // 因为中间夹着一个new，所以要进行两跳
            } else {
                itr.next.random = null;
            }
            itr = itr.next.next;
        }

        Node newHead = head.next;
        itr = head;
        // 进行断链，将new独立出来
        while (itr != null) {
            Node newNode = itr.next;
            itr.next = newNode.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
            itr = itr.next;
        }

        return newHead;
    }
}