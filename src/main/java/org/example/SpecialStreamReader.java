package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class SpecialStreamReader {

    private PriorityQueue<Map.Entry<String, Integer>> minHeap;
    private String words;
    private Integer initialCapacity;

    public SpecialStreamReader(int initialCapacity, String words) {
        minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        this.words = words;
        this.initialCapacity = initialCapacity;
    }


    /*
    * Return k-th most common words from sentence
     */
    public String[] getTop50() {

        // use priority queue correctly!
        String[] wordsArray = this.words.split(" ");
        Map<String, Integer> map = new HashMap<>();

        Stream.of(wordsArray).forEach(word -> {
                if (!map.containsKey(word)){
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word).intValue() + 1);
                }
        });
        // sort the map,
        minHeap.addAll(map.entrySet());

        // pop,  take top n
        while(minHeap.size() > this.initialCapacity) {
            minHeap.remove();
        }

        // convert heap to string array
        return minHeap.stream().map(entry -> entry.getKey()).toArray(size -> new String[size]);
    }
}
