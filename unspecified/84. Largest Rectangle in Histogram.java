// hard


/*
没思路，youtube上有动画视频，好理解一些，后来觉得这种思路还可以
https://www.youtube.com/watch?v=ZmnqCZp9bBs

但还是不太理解为什么
这个注释很详细
https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/

class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        // store index of bar
        Deque<Integer> stack = new LinkedList<>();
        
        int maxArea = 0;
        int area = 0;
        int i = 0;
        while (i < heights.length)
        {
            // 高度递增的顺序
            if (stack.isEmpty() || heights[i] > heights[stack.peek()])
            {
                stack.push(i);
                i++;
            }
            else
            {
                int top = stack.pop();
                if (stack.isEmpty())
                {
                    area = i * heights[top];
                }
                else
                {
                    // 高 * 宽
                    area = heights[top] * (i - stack.peek() - 1);
                }
                
                if (area > maxArea) { maxArea = area; }
            }
        }
        
        // 注意这里的i， 是右边界
        // 这段代码其实可以和上面的合并
        while (!stack.isEmpty())
        {
            int top = stack.pop();
            if (stack.isEmpty())
            {
                area = i * heights[top];
            }
            else
            {
                area = heights[top] * (i - stack.peek() - 1);
            }

            if (area > maxArea) { maxArea = area; }
        }
        
        return maxArea;
    }
}