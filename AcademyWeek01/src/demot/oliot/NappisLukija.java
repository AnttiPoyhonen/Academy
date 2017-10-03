package demot.oliot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NappisLukija {

    public static void main(String[] args) {

        /* Java 8 Stream reading etc
        
        Path dir = Paths.get(".");
        Stream<Path> virta = Files.list(dir);
        virta.filter(Files::isRegularFile)
            .map(p->p.getFileName())
            .forEach(System.out::println);
        
         */

        
        /* in BufferedReader & InputStreamReader
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String rivi = in.readLine(); // luetaan seuraava rivi, voi heittää IOException
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally { // suljetaan Reader
            try {
                in.close();
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
        
         */
    }

}
