package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class SpecialStreamReader {

//    private PriorityQueue<WordFreq> minHeap;
    private String words;

    public SpecialStreamReader(int initialCapacity, String words) {
//        minHeap = new PriorityQueue<WordFreq>(initialCapacity, new Comparator<WordFreq>() {
//            @Override
//            public int compare(WordFreq a, WordFreq b) {
//                return -a.compareTo(b);
//            }
//        });
        words = words;
    }


    public String[] getTop50() {

        // use priority queue correctly!
        // keep adding to the heap
        String[] wordsArray = words.split(" ");
        Map<String, Integer> map = new HashMap<>();

        Stream.of(wordsArray).forEach(word -> {
                if (map.containsKey(word)){
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word).intValue() + 1);
                }
        });
        // when i add , i need the WordFreq incremented


        // pop

        // convert heap to string array
        // sort the map, take top 2

        return new String[]{};
    }
}
