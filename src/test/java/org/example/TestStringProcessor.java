package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestStringProcessor {
    StringProcessor processor = new StringProcessor();

    // 🔹 Test concatenate
    @Test
    public void testConcatenate() {
        assertEquals("HelloWorld", processor.concatenate("Hello", "World"));
    }

    // 🔹 Test concatenate with null
    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateWithNull() {
        processor.concatenate(null, "World");
    }

    // 🔹 Test palindrome true
    @Test
    public void testIsPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }

    // 🔹 Test palindrome false
    @Test
    public void testIsPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }

    // 🔹 Test palindrome null
    @Test
    public void testIsPalindromeNull() {
        assertFalse(processor.isPalindrome(null));
    }
}
