package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class App 
{
    static final String MOBY_DICK_URL = "https://www.gutenberg.org/files/2701/2701-0.txt";

    public static void main( String[] args ) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new URL(MOBY_DICK_URL).openStream());
        byte dataBuffer[] = new byte[1024];
        String writtenWord = "";
        int bytesRead = 0;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            writtenWord += new String(dataBuffer, 0, bytesRead);
        }
        /*
        * TODO: in real life would use Dependency Inversion Principle of depending on an abstract WordFrequencyReader  here
        *  we can take this pattern one further by additionally segregating an abstraction/interface for WordFrequencyStreamReader
        *  which would extend initial functionality based on shape of data coming in
        *
         */
        WordFrequencyStreamReader topFiftyMostFrequentWordsReader = new WordFrequencyStreamReader(writtenWord, 50);
        System.out.print(Arrays.toString(topFiftyMostFrequentWordsReader.getTopKFrequentWordsUnordered()));
    }
}
