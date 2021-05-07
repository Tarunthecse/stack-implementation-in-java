package com.stack.controller;

import com.stack.exception.EmptyStackException;
import com.stack.mapper.StackMapper;
import com.stack.rep.DataRep;
import com.stack.service.StackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping()
public class StackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StackController.class);
    private static final String LOG_PREFIX = "Stack Controller : ";
    @Autowired
    private StackService stackService;

    /**
     * @param data
     * @return 201 if items gets pushed successfully
     */
    @PostMapping(value = "/push/{data}")
    @ResponseStatus(HttpStatus.CREATED)
    public void push(@PathVariable int data) {
        LOGGER.info("{} Pushing element {} to stack ", LOG_PREFIX, data);
        stackService.push(data);
    }

    /**
     * @return 200 with top element if stack is not empty and item pulled removed successfully
     */
    @DeleteMapping(value = "/pop",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public DataRep pop() {
        LOGGER.info("{} Removing top element from stack", LOG_PREFIX);
        try {
            return StackMapper.dataToDataRep(stackService.pop());
        }catch (EmptyStackException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    /**
     * @return  200 with top if stack is not empty and item pulled successfully
     */
    @GetMapping(value = "/peek", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public DataRep peek() {
        LOGGER.info("{} Pulling top element from stack", LOG_PREFIX);
        try {
            return StackMapper.dataToDataRep(stackService.peek());
        } catch (EmptyStackException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

}
