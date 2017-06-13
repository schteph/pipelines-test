package com.bellabeat.pipelinestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class PipelinesControllerTest {
    private final PipelinesController underTest = new PipelinesController();

    private String message = "msg";

    @Test
    public void testAddMessage() {
        String res = underTest.addMessage(message);
        assertEquals(message, res);
    }
    
    public void testGetMessages() {
        List<String> res = underTest.getMessages();
        assertTrue(res.isEmpty());
        underTest.addMessage(message);
        res = underTest.getMessages();
        assertEquals(1, res.size());
        assertTrue(res.contains(message));
    }
}
