// Song
// Paul Freeman April 25, 2019

// A Class to represent a Song.
// Must be constructed with Song Title, Lyrics, and a Lexicon to analyze the lyrics.


import java.util.*;
import java.io.*;

public class Song{

   private String title;
   private String artist;
   private String album;
   
   private List<String> attributes;
   private int[] scores;
   
   
   // Construct Song with Song Title, String of Lyrics, and a Lexicon
   public Song(String title, String lyrics, Lexicon lexicon){   
      this(title,null,null,lyrics,lexicon);
   }
    
   // Construct Song with Song Title, File of Lyrics, and a Lexicon
   public Song(String title, File lyrics, Lexicon lexicon)throws FileNotFoundException{      
      this(title,null,null,lyrics,lexicon);
   }
   
   // Construct Song with Song Title, Artist, Album, String of Lyrics, and a Lexicon
   public Song(String title, String artist, String album, String lyrics, Lexicon lexicon){
      this.title = title;
      this.artist = artist;
      this.album = album;
      this.scores = lexicon.scoreString(lyrics);
      this.attributes = lexicon.getAttributes();
   }
   
   // Construct Song with Song Title, Artist, Album, File of Lyrics, and a Lexicon
   public Song(String title, String artist, String album, File lyrics, Lexicon lexicon)throws FileNotFoundException{
      this.title = title;
      this.artist = artist;
      this.album = album;
      this.scores = lexicon.scoreFile(lyrics);
      this.attributes = lexicon.getAttributes();
   }
   
   public int getAttributeScore(int index){
      return scores[index];
   }
   
   // Prints info about the song.
   public String toString(){
      String result = "Title: " + title;
      result += ", " + "Artist: " + artist;
      result += ", " + "Album: " + album;
      
      for (int i = 0; i < scores.length; i ++){
         result += ", " + attributes.get(i) + ": " + scores[i];
      }
      return result;
   }

}