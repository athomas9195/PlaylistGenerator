// LexiconMain
// Paul Freeman - April 25, 2019

// A Program to text the Lexicon, Song, SongHeap, and related classes.

import java.util.*;
import java.io.*;

public class LexiconMain {

   public static void main(String[] args) throws FileNotFoundException{
      
      File lexicon = new File("lexicon_Formatted.txt");
      
      Lexicon map = new Lexicon(lexicon);
      
//       map.printValues("fighting");
//       map.printValues("notaword");
//       
//       
//       File someLyrics = new File("lyrics/song_TheWildHunt.txt"");
//       int[] tallestScore = map.scoreFile(someLyrics);
//       printScore(tallestScore);
//       
//       
//       Song tallest = new Song("The Wild Hunt", someLyrics, map);     
//       System.out.println(tallest);
      

      // This tests the SongHeap class by creating and adding an album full of songs into a new SongHeap, prioritizing each of the different attributes.
      for (int i = 0; i < map.getAttributes().size(); i ++){
      
         System.out.println("\nPRIORITIZE: " + map.getAttributes().get(i));
         
         SongHeap songQueue = new SongHeap(i);
         
         songQueue.insert(new Song("The Wild Hunt", new File("lyrics/song_TheWildHunt.txt"), map));
         songQueue.insert(new Song("Burden of Tomorrow", new File("lyrics/song_BurdenOfTomorrow.txt"), map));
         songQueue.insert(new Song("Troubles will Be Gone", new File("lyrics/song_TroublesWillBeGone.txt"), map));
         songQueue.insert(new Song("You're Going Back", new File("lyrics/song_YoureGoingBack.txt"), map));
         songQueue.insert(new Song("The Drying Of The Lawns", new File("lyrics/song_TheDryingOfTheLawns.txt"), map));
         songQueue.insert(new Song("King of Spain", new File("lyrics/song_KingOfSpain.txt"), map));
         songQueue.insert(new Song("Love Is All", new File("lyrics/song_LoveIsAll.txt"), map));
         songQueue.insert(new Song("Thousand Ways", new File("lyrics/song_ThousandWays.txt"), map));
         songQueue.insert(new Song("A Lion's Heart", new File("lyrics/song_ALionsHeart.txt"), map));
         songQueue.insert(new Song("Kids On The Run", new File("lyrics/song_KidsOnTheRun.txt"), map));
         
         while (songQueue.size() > 0){
         
            Song song = songQueue.remove();
            System.out.println(song);
         
         }
      }
      
   }
   
   public static void printScore(int[] scores){
   
      for (int i = 0; i < scores.length; i++)
         System.out.print(scores[i] + ", ");
      System.out.println();
   }

}