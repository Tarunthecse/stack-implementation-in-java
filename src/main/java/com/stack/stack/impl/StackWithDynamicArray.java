package com.stack.stack.impl;
import com.stack.exception.EmptyStackException;
/**
 * Stack impl with Dynamic array
 */

public class StackWithDynamicArray {

    private int maxSize;
    private int[] stackArray;
    private int top;

    /**
     * Constructor
     * @param size
     */
    public StackWithDynamicArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }


    /**
     * Add element at the top
     * @param value
     *
     */
    public void push(int value) {
        if (!isFull()) {
            top++;
            stackArray[top] = value;
        } else {
            resize(maxSize * 2);
            push(value);
        }
    }


    /**
     * Remove element from the top
     * @return
     */
    public int pop() {
        if(isEmpty()){
            throw new EmptyStackException("There are no items to peek as stack is empty");
        }
        else{
            if (top < maxSize / 4) {
                shrinkArray(maxSize / 2);
                return pop();
            }
            return stackArray[top--];
        }


    }


    /**
     * @return element from the top
     */
    public int peek() {
        if (!isEmpty()) { // Checks for an empty stack
            return stackArray[top];
        } else {
            throw new EmptyStackException("There are no items to peek as stack is empty");
        }
    }

    public void resize(int newSize) {
        int[] transferArray = new int[newSize];
        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        stackArray = transferArray;
        maxSize = newSize;
    }
    public void shrinkArray(int newSize) {
        int[] transferArray = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            transferArray[i] = stackArray[i];
        }
        stackArray = transferArray;
        maxSize = newSize;
    }


    /**
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (top == -1);
    }


    /**
     * @return true if stack is full
     */
    public boolean isFull() {
        return (top + 1 == maxSize);
    }

    public int getMaxSize() {
        return maxSize;
    }


}
