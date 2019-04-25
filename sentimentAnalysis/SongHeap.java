// SongHeap
// Paul Freeman April 25, 2019

// A class to store Songs utilizing a PriorityQueue

import java.util.*;
import java.io.*;

public class SongHeap{

   private PriorityQueue<Song> heap;
   
   // this is an integer corresponding to the attribute we want to prioritize
   private int attribute;

   // Construct a new Songheap based on a particular attribute
   // (corresponds to an index of the "scores" field in the Song Class.
   // for instance, an attribute of 4 corresponds to Joy using the lexicon created from:
   // http://saifmohammad.com/WebPages/NRC-Emotion-Lexicon.htm
   public SongHeap(int attribute){  
      this.attribute = attribute;   
      this.heap = new PriorityQueue<Song>(new SongPriority(attribute));
   }

   // Inserts a Song into the PriorityQueue.
   public boolean insert(Song song){
      return heap.add(song);
   }
   
   // Retrieves and removes head of queue. Returns null if empty.
   public Song remove(){
      return heap.poll();
   }
   
   // delete a Song if it is present.
   public boolean delete(Song song){
      return heap.remove(song);
   }
   
   // Returns but does not remove the head of the PriorityQueue.
   public Song peek(){
      return heap.peek();
   }
   
   // Returns the Size of the PriorityQueue
   public int size(){
      return heap.size();
   }
   
   // Returns true if PriorityQueue contains a given song...
   public boolean contains(Song song){
      return heap.contains(song);
   }  
   
   // This comparator should do reverse order (let us use priority queue as a maxheap
   private class SongPriority implements Comparator<Song> {  
      private int attribute;      
      public SongPriority(int attribute){
         this.attribute = attribute;
      }
      
      public int compare(Song song1, Song song2){
         return song2.getAttributeScore(attribute) - song1.getAttributeScore(attribute);
      }
   }
   


}