package dataStructure.stack;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class TestStack {
    private static Logger logger = Logger.getLogger(TestStack.class);
    //栈，这里使用数组存储数据模拟栈底层存储
    private int[] stack;

    public static void main(String[] ljk) {
        TestStack testStack = new TestStack();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);
        System.out.println(Arrays.toString(testStack.stack));
        testStack.pop();
        System.out.println(Arrays.toString(testStack.stack));
    }

    private TestStack() {
        stack = new int[0];
    }

    //入栈
    private void push(int value) {
        int[] newStack = new int[stack.length + 1];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        newStack[stack.length] = value;
        stack = newStack;
    }

    //出栈
    private void pop() {
        if (0 == stack.length) {
            logger.error("stack is null ,please don't to pop");
            return;
        }
        int[] newStack = new int[stack.length - 1];
        System.arraycopy(stack, 0, newStack, 0, newStack.length);
        stack = newStack;
    }
}
