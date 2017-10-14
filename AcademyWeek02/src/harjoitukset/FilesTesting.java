package harjoitukset;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTesting {

    static Class luokka = CaesarCode.class;
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        etsiLuokka(luokka);

        tulostaJava8();
        tulostaJava7();

    }

    private static void tulostaJava7() throws IOException {

        // path
        System.out.println("Path: " + Paths.get(System.getProperty("user.home")) + "\n");

        // Java 8 DirectoryStream and for..each
        System.out.println("\n\nDIR ITERATED WITH DIRECTORYSTREAM (JAVA 8):\n");

        // print files
        DirectoryStream<Path> dirFiles = Files.newDirectoryStream(Paths.get(System.getProperty("user.home")));

        for (Path b : dirFiles) {
            if (Files.isRegularFile(b)) {
                System.out.println("File: " + b.getFileName());
            }
        }

        System.out.println("");

        // print directories
        DirectoryStream<Path> dirDirs = Files.newDirectoryStream(Paths.get(System.getProperty("user.home")));

        for (Path p : dirDirs) {
            if (Files.isDirectory(p)) {
                System.out.println("Directory: " + p.getFileName());
            }
        }

    }

    private static void tulostaJava8() {

        // Java 7 File
        System.out.println("\n\nDIR FILES ITERATED WITH FILE (JAVA 7):\n");

        File home = new File(Paths.get(System.getProperty("user.home")).toString());

        if (home.isDirectory()) {
            for (File file : home.listFiles()) {
                // String info = file.isFile() ? "File" : "Directory";

                // print only files
                if (file.isFile()) {
                    System.out.println("File - " + file.getName());
                }
            }
        }

    }

    private static void etsiLuokka(Class l) {

        System.out.println("Haetaan luokkaa " + l.getName());
        
        String classname = l.getName();
        String classpath = classname.replaceAll("\\.", "/");
        classpath = classpath + ".java";
        
        Path dotjavapath = Paths.get("src").resolve(classpath);
        
        System.out.println("Polku: " + dotjavapath);
        
        // C:\coding\Academy\packages\AcademyWeek02\harjoitukset\FilesTesting
                
        boolean isThere = Files.exists(dotjavapath);
        
        if (isThere) System.out.println("Löytyi lähdekoodi!");
        else System.out.println("Ei löydy lähdeköödeja!");
    }

}
