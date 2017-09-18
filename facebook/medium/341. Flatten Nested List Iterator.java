// medium



// fail twice
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    // 直接存放该数据结构
    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        // store from end to start, so first at head in stack
        for (int i = nestedList.size() - 1; i >= 0; i--)
        {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty())
        {
            if (stack.peek().isInteger())
            {
                return true;
            }

            // 继续flatten list, 若是empty list则说明也不加入到stack中了
            NestedInteger n = stack.pop();
            for (int i = n.getList().size() - 1; i >= 0; i--)
            {
                stack.push(n.getList().get(i));
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
