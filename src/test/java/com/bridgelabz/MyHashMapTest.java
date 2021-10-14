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

    @Test
    public void givenSentence_whenWordsAreAddedToList_shouldReturnParanoidWordFrequency()
    {
        String sentence="Paranoids are not paranoid because they are paranoid but " + "because they keep putting themselves deliberately " +
                        "into paranoid avoidable situations";
        MyHashMapParanoid<String,Integer> myHashMapParanoid=new MyHashMapParanoid<>();
        String[] words=sentence.toLowerCase().split(" ");
        for(String word:words)
        {
            Integer value=myHashMapParanoid.get(word);
            if(value==null)
                value=1;
            else
                value+=1;
            myHashMapParanoid.add(word,value);
        }
        System.out.println(myHashMapParanoid);
        int frequency=myHashMapParanoid.get("paranoid");
        Assertions.assertEquals(3,frequency);
    }
    @Test
    public void givenASentence_whenRemovedAvoidableWord_shouldRemoveAvoidableWord(){
        String sentence = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately " +
                "into paranoid avoidable situations";
        MyHashMapParanoid<String, Integer> myLinkedHashMap = new MyHashMapParanoid<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value += 1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println("before:" + myLinkedHashMap);
        myLinkedHashMap.remove("avoidable");
        System.out.println("after: " + myLinkedHashMap);
        Integer removedWordFrequency = myLinkedHashMap.get("avoidable");
        Assertions.assertEquals(null,removedWordFrequency);
    }
}
