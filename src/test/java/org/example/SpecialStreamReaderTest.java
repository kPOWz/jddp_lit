package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialStreamReaderTest {

    //TODO: not skipping any words

    @Test
    void shouldTrackTop2() {
        String words = "dog cat bird cat dog donkey horse";
        var ssr = new SpecialStreamReader(2, words);

        var observed = ssr.getTop50();



        String[] expectedTop2 = {"dog", "cat"};
        assertArrayEquals(expectedTop2, observed);
    }

    @Test
    void shouldTrackTop50() {

    }

}