// medium

class MyStack {

    Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() 
    {
        que = new LinkedList<>();    
    }
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
        que.add(x);
        int size = que.size();
        for (int i = 0; i < size - 1; i++)
        {
            que.add(que.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        return que.poll();    
    }
    
    /** Get the top element. */
    public int top() 
    {
        return que.peek();    
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return que.isEmpty();   
    }
}