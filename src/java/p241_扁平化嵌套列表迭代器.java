package java;

/**
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 *
 *
 *
 */

import java.util.*;


// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
 }


public class NestedIterator implements Iterator<Integer> {

      Deque<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        Iterator<NestedInteger> iterator = nestedList.iterator();
        stack.push(iterator);
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            // 遍历到当前列表的末尾了，出栈
            if (!it.hasNext()) {
                stack.pop();
                continue;
            }

            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> tmp = new ArrayList<>();
                tmp.add(nest);
                stack.push(tmp.iterator());
                return true;
            } else {
                stack.push(nest.getList().iterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */