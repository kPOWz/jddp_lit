package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyStreamReader {

    private static final String EXCLUDE_WORDS = "the,of,to,and,a,in,is,it,you,that,he,was,for,on,are,with,as,I,his,they,be,at,one,have,this,from,or,had,by,not,word,but,what,some,we,can,out,other,were,all,there,when,up,use,your,how,said,an,each,she";
    private static final Map<String, Integer> excludeWordsMap = Stream.of(EXCLUDE_WORDS.split(","))
            .map(s -> new AbstractMap.SimpleImmutableEntry<>(s.toLowerCase(Locale.ROOT), 0))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    private String words;
    private Map<String, Integer> map;
    private PriorityQueue<Map.Entry<String, Integer>> minHeap;

    public WordFrequencyStreamReader(String words, int frequencyLimit) {
        this.words = words;
        this.map = new HashMap<>();

        String[] wordsArray = this.words.split(" ");
        Stream.of(wordsArray).forEach(word -> {
            if( isWordIncluded(word.toLowerCase(Locale.ROOT))) {
                this.map.put(word, this.map.getOrDefault(word, 0) + 1);
            }
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

    private boolean isWordIncluded(String word) {
        return !excludeWordsMap.containsKey(word);
    }
}
