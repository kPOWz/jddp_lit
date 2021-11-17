package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyStreamReaderTest {
    @Test
    void shouldGetTop2() {
        String words = "dog cat bird cat dog donkey horse dog";
        var ssr = new WordFrequencyStreamReader(words, 2);

        var observed = ssr.getTopKFrequentWordsUnordered();

        String[] expectedTop2 = {"cat", "dog"};
        assertTrue(expectedTop2.length == observed.length);
        assertTrue(Arrays.asList(expectedTop2).containsAll(Arrays.asList(observed)));
    }

    @Test
    void shouldGetTop3() {
        String words = "dog cat bird cat dog donkey horse dog monkey horse dog cat";
        var ssr = new WordFrequencyStreamReader(words, 3);

        var observedMostFrequent3 = ssr.getTopKFrequentWordsUnordered();

        String[] expectedTop3 = {"horse", "cat", "dog"};
        assertTrue(expectedTop3.length == observedMostFrequent3.length);
        assertTrue(Arrays.asList(expectedTop3).containsAll(Arrays.asList(observedMostFrequent3)));
    }

    @Test
    void shouldGetAsManyAsPossible() {
        String words = "dog cat bird cat dog donkey horse dog";
        var ssr = new WordFrequencyStreamReader(words, 12);

        var observed = ssr.getTopKFrequentWordsUnordered();

        String[] expectedTop2 = {"cat", "dog", "bird", "donkey", "horse"};
        assertTrue(expectedTop2.length == observed.length);
        assertTrue(Arrays.asList(expectedTop2).containsAll(Arrays.asList(observed)));
    }

}