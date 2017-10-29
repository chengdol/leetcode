// easy


// 想出来了，用2个stack: in, out
// in 负责push使用
// out 负责pop peak使用，若为空，则将in pop进来再peak /pop
class MyQueue {

    Deque<Integer> in;
    Deque<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue()
    {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x)
    {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop()
    {
        peek();
        return out.pop();
    }

    /** Get the front element. */
    public int peek()
    {
        if (out.isEmpty())
        {
            while (!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty()
    {
        return in.isEmpty() && out.isEmpty();
    }
}
