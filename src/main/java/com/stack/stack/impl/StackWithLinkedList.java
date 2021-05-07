package com.stack.stack.impl;

import com.stack.exception.EmptyStackException;
import com.stack.model.StackNode;

public class StackWithLinkedList<T>{

    private StackNode<T> root;

    /**
     *
     * @return true if stack is empty
     */
    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Push element on the top
     * @param data
     */
    public void push(T data){
        StackNode<T> stackNode = new StackNode<>();
        stackNode.setData(data);
        stackNode.setNext(root);

        this.root = stackNode;
    }

    /**
     * @return and remove top element of the stack
     */
    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException("There are no items to pop as stack is empty");
        }

        StackNode<T> tempNode = this.root;
        this.root = tempNode.getNext();

        return tempNode.getData();
    }

    /**
     * @return top element of the stack
     */
    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException("There are no items to peek as stack is empty");
        }

        return this.root.getData();
    }
}