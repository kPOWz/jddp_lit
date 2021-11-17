package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    void addition() {
        assertEquals(2, 2);
    }

    @Test
    @DisplayName("is empty")
    void isEmpty() {
        Stack<Object> stack;
        stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }



}
