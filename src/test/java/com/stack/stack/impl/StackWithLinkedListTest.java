package com.stack.stack.impl;

import com.stack.exception.EmptyStackException;
import com.stack.stack.impl.StackWithLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class StackWithLinkedListTest {

    @Test
    public void pushInteger(){
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        Assert.assertEquals(40, stack.peek());
        Assert.assertEquals(40, stack.pop());
        Assert.assertEquals(30, stack.pop());
        Assert.assertEquals(20, stack.pop());
    }

    @Test
    public void pushString(){
        StackWithLinkedList<String> stack = new StackWithLinkedList<>();
        stack.push("abc");
        stack.push("def");
        stack.push("ghi");
        Assert.assertEquals("ghi", stack.peek());
        Assert.assertEquals("ghi", stack.pop());
        Assert.assertEquals("def", stack.pop());
        Assert.assertEquals("abc", stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void popEmptyStack(){
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void peekEmptyStack(){
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.peek();
    }
    @Test
    public void isEmpty(){
        StackWithLinkedList stack = new StackWithLinkedList();
        Assert.assertEquals(true, stack.isEmpty());
        stack.push(20);
        Assert.assertEquals(false, stack.isEmpty());
        Assert.assertEquals(20, stack.pop());
        Assert.assertEquals(true, stack.isEmpty());
    }
}
