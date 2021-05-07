package com.stack.stack.impl;

import com.stack.exception.EmptyStackException;
import org.junit.Assert;
import org.junit.Test;


public class StackWithDynamicArrayTest {
    @Test
    public void push(){
        StackWithDynamicArray stack = new StackWithDynamicArray(2);
        Assert.assertEquals(true, stack.isEmpty());
        stack.push(20);
        stack.push(30);
        Assert.assertEquals(30, stack.peek());
        Assert.assertEquals(30, stack.pop());
        Assert.assertEquals(20, stack.peek());
        Assert.assertEquals(20, stack.pop());
    }
    @Test(expected = EmptyStackException.class)
    public void popEmptyArray(){
        StackWithDynamicArray stack = new StackWithDynamicArray(2);
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void peekEmptyArray(){
        StackWithDynamicArray stack = new StackWithDynamicArray(2);
        stack.pop();
    }

    @Test
    public void shrinkArray(){
        StackWithDynamicArray stack = new StackWithDynamicArray(8);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        Assert.assertEquals(8, stack.getMaxSize());
        stack.shrinkArray(4);
        Assert.assertEquals(4, stack.getMaxSize());

    }
    @Test
    public void resizeArray(){
        StackWithDynamicArray stack = new StackWithDynamicArray(2);
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.getMaxSize());
        stack.push(3);
        Assert.assertEquals(4, stack.getMaxSize());

    }
}
