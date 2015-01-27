import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.IOException;

public class MyFirstLineNumberReader {
   public static void main(String[] args) throws IOException {
      LineNumberReader lnr = null;
      String line = null;
      
      try {
         // create new reader 
         lnr = new LineNumberReader(new FileReader(args[0]));
   
         // read lines till the end of the stream
         while((line = lnr.readLine()) != null) {
            // Prints string with line number
            System.out.println(lnr.getLineNumber() + ".- " + line);
         }
      } catch(Exception e) {
         // if any error occurs
         e.printStackTrace();
      } finally {
         // closes the stream; releasing system resources
         if(lnr != null) { lnr.close(); }
      }
   }
}
