package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    private Assert Assertions;
    //private TestCase Assertions;

    //testcase to find the frequency of given words are true
    @Test
    public void givenSentence_whenWordsAreAddedToList_shouldReturnWordFrequency()
    {
        String sentence="To Be or not To be";
        MyHashMap<String,Integer> myHashMap=new MyHashMap<>();
        String[] words=sentence.toLowerCase().split(" ");
        for(String word:words)
        {
            Integer value=myHashMap.get(word);
            if(value==null)
                value=1;
            else
                value+=1;
            myHashMap.add(word,value);
        }
        int frequency = myHashMap.get("to");
        System.out.println(myHashMap);
        Assertions.assertEquals(2, frequency);
    }
}
