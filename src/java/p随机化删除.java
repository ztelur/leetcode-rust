/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2022 All Rights Reserved.
 */
package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author libing
 * @version $Id: p随机化删除.java, v 0.1 2022年02月23日 下午3:50 zt Exp $
 */
class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    // 题目的关键在于 remove
    // 并不是直接将其删除，而是将其用最后一个元素代替，然后删除最后一个元素
    // 0 0 1 1 remove 0 时，如果直接删除，则 1 1 明显是不符合要求的，而进行替换就变成了 1 0 就是正确的了
    public boolean remove(int val) {
        if (! map.containsKey(val)) return false;

        // 最后一个元素
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */