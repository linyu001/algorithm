package actual;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void offer(Integer element) {
        stackA.push(element);
    }

    public void transfer() {
        while (!stackA.empty()) {
            stackB.push(stackA.pop());
        }
    }

    public Integer pop() {
        if (stackB.empty()) {
            if (stackA.empty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.offer(2);
        queue.offer(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
