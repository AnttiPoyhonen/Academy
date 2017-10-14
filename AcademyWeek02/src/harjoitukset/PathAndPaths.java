package harjoitukset;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndPaths {

    public static void main(String[] args) {
        
        Path p = Paths.get("src", "harjoitukset", "PathAndPaths.java");
        Path abs = p.toAbsolutePath();
        
        System.out.println("Tiedoston nimi: " + p.getName(p.getNameCount()-1));
        System.out.println("");
      
        analyse(p);
        
        
        // testing analysis
        System.out.println("\nTESTING:\n");
        analyse(Paths.get("src/fi/academy/Main.java"));
        analyse(Paths.get("src/../src/./fi/academy/roska/../perjantai"));
        analyse(Paths.get(System.getProperty("java.home")).resolve("bin").resolve("java.exe"));
        analyse(Paths.get(System.getProperty("java.io.tmpdir")));
        
        
        // Normalizing, resolving, relativizing
        System.out.println("NORMALIZE:");
        
        Path m = Paths.get("/src/./harjoitukset/../PathAndPaths.java");
        System.out.println(m.normalize());
        System.out.println("");
        
        System.out.println("RESOLVE:");
        Path dot = Paths.get(".");
        
        System.out.println("Resolved (.) to path: " + dot.resolve(p));
        System.out.println("Resolved (.) to absolute path: " + dot.resolve(abs));
        System.out.println("");
        
        System.out.println("RELATIVIZED:");
        System.out.println("Relativized (.) to path: " + dot.relativize(p));
        System.out.println("Relativized (.) to absolute path: " + dot.toAbsolutePath().relativize(abs));
        System.out.println("");
        
        System.out.println("RELATIVIZED AND RESOLVED:");
        Path rPath = dot.relativize(p);
        System.out.println("Relativized and resolved (.) to path: " + dot.resolve(rPath));
        Path rAbsPath = dot.toAbsolutePath().relativize(abs).resolve(abs);
        System.out.println("Relativized and resolved (.) to absolute path: " + rAbsPath);
        System.out.println("");        
      
    }

    private static void analyse(Path p) {
        
        System.out.println("Path: \t\t\t" + p);
        System.out.println("Absolute?: \t\t" + p.isAbsolute());
        System.out.println("Path (absolute):\t" + p.toAbsolutePath());
        System.out.println("Exists?: \t\t" + Files.exists(p));
        
        String type;
        
        if (Files.isDirectory(p)) {
            type = "directory";
        } else if (Files.isRegularFile(p)) {
            type = "file";
        } else type = "undetermined, does not exist?";
        
        System.out.println("File/Directory?:\t" + type);
        
        System.out.println("Name: \t\t\t" + p.getName(p.getNameCount()-1));
        
        String ext = null;
        
        if (Files.isRegularFile(p)) {
                String filename = p.getFileName().toString();
                int dotIndex = filename.lastIndexOf('.');
                if (dotIndex >= 0) {
                    ext = filename.substring(dotIndex);
                } else ext = "no extension - not a file?";
        }
        else ext = "not a file";
                
        System.out.println("File extension:\t\t" + ext);
        
        System.out.println("");
       
}
    
}
