package actual;

import java.util.Stack;

/**
 * 最小栈
 * 使用2个栈，其中一个栈作为普通栈使用，另一个只把最小的元素入栈。
 * 入栈：如果元素小于或等于最小元素栈顶，则入最小元素栈
 * 出栈：如果元素等于最小元素栈顶，则最小元素出栈
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {
        mainStack.push(element);
        if (minStack.empty()|| minStack.peek() > element) {
            minStack.push(element);
        }
    }

    public Integer pop(){
        if(minStack.peek().equals(mainStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() throws Exception {
        if(mainStack.empty()){
            throw new Exception("stack is null");

        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack=new MinStack();
        stack.push(6);
        stack.push(8);
        stack.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
