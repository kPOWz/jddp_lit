package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class SpecialStreamReader {

    private String words;
    private Comparator<Map.Entry<String, Integer>> entryComparator;

    public SpecialStreamReader(String words) {
        this.words = words;
    }

    /*
    * Return k-th most common words from sentence
     */
    public String[] getTopKFrequentWordsAscending(int k) {
        String[] wordsArray = this.words.split(" ");
        Map<String, Integer> map = new HashMap<>();

        Stream.of(wordsArray).forEach(word -> {
            map.put(word, map.getOrDefault(word, 0) + 1);
        });

        // this essentially sorts the map, O(n log n)
        // the collection constructor PriorityQueue() -> initFromCollection is better (O(n)), but couldn't use due to needing Comparator
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        minHeap.addAll(map.entrySet());

        // pop until top n & then heap siftDown
        //  O((n-k) log n)
        while(minHeap.size() > k) {
            minHeap.remove();
        }

        // convert heap to string array
        return minHeap.stream().map(entry -> entry.getKey()).toArray(size -> new String[size]);
    }
}
