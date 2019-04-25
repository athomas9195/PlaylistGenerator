// This tool allows for the reformatting of Lexicons from http://saifmohammad.com/WebPages/NRC-Emotion-Lexicon.htm
// May process lexicons in the format where there are 10 attributes... i.e. each word appears on 10 successive lines.
// <word> <attribute> <score>
// <word> <attribute> <score>
// <word> <attribute> <score>
// <word> <attribute> <score>

// Once a file is read in, you can save a reformatted version with saveNewFormat(newfilename)
// in the format: 
// line 1:     <attribute1> <attribute2> ... <attribute10>
// line 2-n:   <word> <score1> <score2> <score3> ... <score10>
 

import java.util.*;
import java.io.*;

public class LexiconMap {

   private Map<String, int[]> map;
   private List<String> attributes;

   public LexiconMap(){
      this.map = new TreeMap<String, int[]>();
      this.attributes = new ArrayList<String>();  
   }
   
   // Read in a new file to generate a map. Takes a File.
   public void readFile(File lexicon) throws FileNotFoundException{
   
   Scanner fileScanner = new Scanner(lexicon);
   
  
   while (fileScanner.hasNextLine()){
      String line = fileScanner.nextLine();
      String[] tokens = line.split("[ \t]+");
      
      if (!attributes.contains(tokens[1]))
         attributes.add(tokens[1]);
      
      int[] values = new int[10];
      if (!map.keySet().contains(tokens[0]))
         values[0] = Integer.valueOf(tokens[2]);     
         for (int i = 1; i < 10; i++){         
            line = fileScanner.nextLine();
            tokens = line.split("[ \t]+");
            if (!attributes.contains(tokens[1]))
               attributes.add(tokens[1]);
            values[i] = Integer.valueOf(tokens[2]);
         }      
         map.put(tokens[0], values);     
      }
   
   }
   
   public void printValues(String key){
      int[] values = map.get(key);
      
      for(int i = 0; i < values.length; i++)
         System.out.print(values[i] + ", ");
         System.out.println();
   }
   
   // Save the reformatted Lexicon. Takes String for the filename.
   public void saveNewFormat(String fileName) throws FileNotFoundException{
   
      PrintStream output = new PrintStream(new File(fileName)); 
      
      
      //first print attributes
      output.print(attributes.get(0));
      for (int i = 1; i < this.attributes.size(); i++)
         output.print("," + this.attributes.get(i));
      output.print("\n");
      
      int[] values;
      for (String key : map.keySet()){
         output.print(key);
         values = map.get(key);
         for (int i = 0; i < values.length; i++){
            output.print("," + values[i]);
         }
         output.print("\n");
      }   
   }
}