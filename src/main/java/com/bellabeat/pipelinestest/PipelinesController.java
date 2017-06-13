package com.bellabeat.pipelinestest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stjep
 */
@RestController
public class PipelinesController {

    private static final List<String> MESSAGES = Collections.synchronizedList(new LinkedList<>());
    
    @PostMapping(value = "/")
    public String addMessage(@RequestParam("message") String message) {
        MESSAGES.add(message);
        return message;
    }
    
    @GetMapping("/")
    public List<String> getMessages() {
        return Collections.unmodifiableList(MESSAGES);
    }
}
