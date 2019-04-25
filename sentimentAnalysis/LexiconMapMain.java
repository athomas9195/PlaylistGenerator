import java.util.*;
import java.io.*;

public class LexiconMapMain {

   public static void main(String[] args) throws FileNotFoundException{
      
      File lexicon = new File("lexicon.txt");
      
      LexiconMap map = new LexiconMap();
      
      map.readFile(lexicon);
      
      map.printValues("fighting");
      
      map.saveNewFormat("lexicon_Formatted2.txt");
      
   }

}