package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class WordFrequencyStreamReader {

    private String words;
    private Map<String, Integer> map;
    private PriorityQueue<Map.Entry<String, Integer>> minHeap;

    public WordFrequencyStreamReader(String words, int frequencyLimit) {
        this.words = words;
        this.map = new HashMap<>();

        String[] wordsArray = this.words.split(" ");
        Stream.of(wordsArray).forEach(word -> {
            this.map.put(word, this.map.getOrDefault(word, 0) + 1);
        });

        // this essentially sorts the map, O(n log n)
        // the collection constructor PriorityQueue() -> initFromCollection is better (O(n)), but couldn't use due to needing Comparator
        minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        minHeap.addAll(this.map.entrySet());

        // pop until top n & then heap data structure does siftDown
        //  O((n-k) log n)
        while(minHeap.size() > frequencyLimit) {
            minHeap.remove();
        }
    }

    /*
    * Return k-th most common words from sentence
     */
    public String[] getTopKFrequentWordsUnordered() {
        // convert heap to string array
        return this.minHeap.stream().map(entry -> entry.getKey()).toArray(size -> new String[size]);
    }

    /* TODO:
    *  to be a "stream" reader would need to implement an add() or two
    *  would simply do a map.put & minheap.add (size 51) & minheap.remove() (size 50 again)
     */
    public void add(String word) {}
    public void add(String[] word) {}
}
