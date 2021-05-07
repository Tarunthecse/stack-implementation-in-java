package com.stack.service;

import com.stack.stack.impl.StackWithDynamicArray;
import org.springframework.stereotype.Service;

/**
 * StackService for doing operations on stack
 */
@Service
public class StackService {

    private StackWithDynamicArray stack;

    /**
     * Initializing stack with size 2, it can be any number.
     */
    public StackService() {
        stack = new StackWithDynamicArray(2);
    }

    public void push(int data) {
        stack.push(data);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }
}
