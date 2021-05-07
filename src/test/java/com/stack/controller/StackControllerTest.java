package com.stack.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stack.exception.EmptyStackException;
import com.stack.service.StackService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StackController.class)
@ContextConfiguration
public class StackControllerTest {

    private static final String POP_URI = "/pop";
    private static final String PUSH_URI = "/push/{data}";
    private static final String PEEK_URI = "/peek";
    private static final String ERROR_MESSAGE = "Empty Stack";
    private static final int data = 123;
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StackService stackService;

    @Autowired
    private StackController stackController;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void peek() throws Exception {
        Mockito.when(stackService.peek()).thenThrow(new EmptyStackException(ERROR_MESSAGE));
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(PEEK_URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andReturn();
        Assert.assertEquals(ERROR_MESSAGE , result.getResponse().getErrorMessage());
    }
    @Test
    public void push() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(PUSH_URI,data)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    public void pop() throws Exception {
        Mockito.when(stackService.pop()).thenThrow(new EmptyStackException(ERROR_MESSAGE));
        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(POP_URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andReturn();
        Assert.assertEquals(ERROR_MESSAGE , result.getResponse().getErrorMessage());
    }


}
