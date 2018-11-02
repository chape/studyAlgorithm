package leetcode.easy.stack_queue_heap;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by ChaoChao on 2018/11/2.
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack_155 minStack = new MinStack_155();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.
 */
class MinStack_155 {

    /**
     * 使用额外堆栈存储当前最小元素 每次push元素时，先判断mStack栈顶元素是否大于x 是则将x push到mStack 否则将mStack栈顶元素push进去
     */
    Stack<Integer> dataStack;
    Stack<Integer> mStack;

    /** initialize your data structure here. */
    public MinStack_155() {
        dataStack = new Stack<>();
        mStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(!mStack.isEmpty()) {
            if(mStack.peek() > x) {
                mStack.push(x);
            } else {
                mStack.push(mStack.peek());
            }
        } else {
            mStack.push(x);
        }
    }

    public void pop() {
        dataStack.pop();
        mStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }
}

/**
 * Your MinStack_155 object will be instantiated and called as such:
 * MinStack_155 obj = new MinStack_155();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */