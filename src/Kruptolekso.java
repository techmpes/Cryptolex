
import java.io.*;
import java.util.*;
import javax.swing.SwingUtilities;

public class Kruptolekso {
    
    static ArrayList <String> list=new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream("words.txt"), "ISO-8859-7"));
        String line;
        while((line = br.readLine())!= null){
            list.add(line);
        }
        SwingUtilities.invokeLater(() -> {
            Grafiko grafiko = new Grafiko();
            grafiko.setgrafiko(list, grafiko);
        });
        
    }
    
    
}
