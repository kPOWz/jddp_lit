package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFreqTest {

    @Test
    void shouldCompareAsEqual() {
        WordFreq wordFreq = new WordFreq("cat", 2);
        WordFreq wordFreq1 = new WordFreq("dog", 2);

        assertEquals(0, wordFreq.compareTo(wordFreq1));

    }

    @Test
    void shouldCompareAsGreater() {
        WordFreq wordFreq = new WordFreq("cat", 2);
        WordFreq wordFreq1 = new WordFreq("dog", 1);

        assertEquals(1, wordFreq.compareTo(wordFreq1));
    }

    @Test
    void shouldCompareAsLessThan() {
        WordFreq wordFreq = new WordFreq("cat", 1);
        WordFreq wordFreq1 = new WordFreq("dog", 2);

        assertEquals(-1, wordFreq.compareTo(wordFreq1));
    }



}