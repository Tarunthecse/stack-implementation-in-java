package com.stack.model;

/**
 * Stack impl with linked list
 * This class will be used as linked list node, data will contain actual data and next will point out to next node
 */
public class StackNode<T> {
    private T data;
    private StackNode next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}