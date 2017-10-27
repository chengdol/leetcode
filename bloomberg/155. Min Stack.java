// easy

// how to get min in constant time?
// using inner class to wrap min value
class MinStack {

    class Element
    {
        int min;
        int val;
        Element(int val, int min)
        {
            this.val = val;
            this.min = min;
        }
    }

    private Deque<Element> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        // update min， 每次push都要检查当前的min是什么
        int min = stack.isEmpty()? x : Math.min(x, getMin());
        stack.push(new Element(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}








