package org.example;

public class WordFreq implements Comparable<WordFreq>{

    private String word;
    private int count;

    public WordFreq(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordFreq o) {
        if (this.count > o.count) {
            return 1;
        }
        if (this.count == o.count) {
            return 0;
        }
        return -1;
    }
}
