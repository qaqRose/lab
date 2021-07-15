package io.github.qxqrose.leetcode.day1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: QXQ
 * @time: 2021/7/14 22:46
 * @desc: TODO
 *
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class Question232 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

     static class MyQueue {

         Deque<Integer> stack1 = new ArrayDeque<>(0);
         Deque<Integer> stack2 = new ArrayDeque<>(0);

         // 栈操作
         // push  进
         // pollLast 出
         // peekLast 获取栈顶数据

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            // 栈2为空
            if(stack2.isEmpty()) {
                // 将栈1元素全部压到栈2
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pollLast());
                }
            }
            // 取 栈2的栈顶
            return stack2.pollLast();
        }

        /** Get the front element. */
        public int peek() {
            // 栈2为空
            if(stack2.isEmpty()) {
                // 将栈1元素全部压到栈2
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pollLast());
                }
            }
            // 取 栈2的栈顶
            return stack2.peekLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            // 两个栈均为空，则队列为空
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
