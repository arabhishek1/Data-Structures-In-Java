package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by abhishek.ar on 25/07/17.
 Given a string with repeated characters, task is rearrange characters in a string so that no two adjacent characters
 are same.

 Examples:

 Input: aaabc
 Output: abaca

 Input: aaabb
 Output: ababa

 Input: aa
 Output: Not Possible

 Input: aaaabc
 Output: Not Possible
 */

class Key{
    char ch;
    int frequency;

    public Key(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }
}

class KeyComparator implements Comparator<Key>{

    @Override
    //Always compares object1 with object2. Based on the what aspect to compare you can return the values.
    //For Maxheap we use this less function which checks minimum of two.
    public int compare(Key o1, Key o2) {
        if (o1.frequency == o2.frequency)
            return 0;
        else if (o1.frequency < o2.frequency)
            return 1;
        else
            return -1;
    }
}

public class RearrangeRepeatingChacracters {

    public static String rearrangeString(String str){

        //Build the character, frequency o map
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(int i=0; i < str.length(); ++i){
            char character = str.charAt(i);
            if (charCountMap.containsKey(character)){
                charCountMap.put(character, charCountMap.get(character) +1);
            } else {
                charCountMap.put(character, 1);
            }
        }


        //Populate PQ
        KeyComparator comparator = new KeyComparator();
        PriorityQueue<Key> priorityQueue = new PriorityQueue<Key>(comparator);
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            priorityQueue.add(new Key(entry.getKey(), entry.getValue()));
        }

        //Rearrange by popping pq and use frequency check to push it again.
        String newStr = "";
        Key prev = new Key('#', -1) ;
        while(!priorityQueue.isEmpty()){
            Key k = priorityQueue.poll();
            newStr += k.ch;


            if(prev.frequency > 0){
                priorityQueue.add(prev);
            }

            (k.frequency)--;
            prev = k;
        }

        return newStr;
    }

    public static void main(String[] args) {
        String str = "aaacc";
        System.out.println(rearrangeString(str));
    }
}
