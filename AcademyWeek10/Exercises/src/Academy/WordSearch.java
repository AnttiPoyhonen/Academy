package Academy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class WordSearch {

    private static String searchWord = "java", searchDir = ".";
    private static List<String> options = new ArrayList<>();
    private static List<Path> filePaths = null;
    private static List<WordSearchResult> results = null;

    public static void main(String[] args) {

        // query for searchword and directory
        searchQuery(args);

        // find all filepaths to list
        filePaths = findAllPaths(searchDir);

        // search through all the files for the searchword, return list of WordSearchResult objects
        results = findResults(filePaths, searchWord);

        // print out search results as "searchword - filename, row, path"
        printResults(searchWord, results);
    }

    private static void searchQuery(String[] args) {

        // if there are no arguments, use defaults
        // if there is 1 argument, it is a searchWord
        // if 2 arguments, first searchDir, second searchWord
        // if 3+ arguments, rest are options
        int l = args.length;

        if (l != 0) {
            if (l == 1) {
                searchWord = args[0];
            } else if (l == 2) {
                searchDir = args[0].replace("\\", "/");
                searchWord = args[1];
            } else {
                searchDir = args[0].replace("\\", "/");
                searchWord = args[1];
                for (int i = 2; i <= l; i++) {
                    options.add(args[i]);
                }
            }
        }

    }

    private static List<Path> findAllPaths(String searchDir) {

        List<Path> list = new ArrayList<>();

        Path dir = Paths.get(searchDir);

        try (Stream<Path> paths = Files.walk(dir)) {
            paths.filter(path -> path.toFile().isFile())
                    .forEach(path -> {
//                        System.out.println(path);
                        list.add(path);
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // check if all (and no directories) filepaths are included
        // for (Path p : list) {
        //    System.out.println(p);
        // }
        return list;

    }

    private static List<WordSearchResult> findResults(List<Path> filePaths, String searchWord) {

        List<WordSearchResult> list = new ArrayList<>();

        for (Path p : filePaths) {
            
            String filename = p.getFileName().toString();
            File f = p.toFile();

            WordSearchResult result = new WordSearchResult(p, filename);

            try (Scanner s = new Scanner(f)) {
                
                int counter = 0;
                while (s.hasNextLine()) {
                    
                    String row = s.nextLine();
                    counter++;

                    if (row.contains(searchWord)) {
                        result.addRow(counter);
                    }
                }
                
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
            
            if(result.getRows().size() > 0) list.add(result);

        }

        return list;

    }

    private static void printResults(String searchWord, List<WordSearchResult> results) {
        
        System.out.println("");
        
        for(WordSearchResult result : results) {
            System.out.println("Searching for: " + searchWord + " - " + result);
        }
        
    }

    private static class WordSearchResult {

        Path path = null;
        String filename = "";
        List<String> rows = new ArrayList<>();

        public WordSearchResult() {

        }

        public WordSearchResult(Path p, String file) {
            this.path = p;
            this.filename = file;
        }

        public void addRow(int i) {
            rows.add(i + "");
        }
        
        public List<String> getRows() {
            return rows;
        }

        public String printRows() {
            return String.join(", ", rows);
        }

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }
        
        
        // print out search results as "searchword - filename, rows - path"
        @Override
        public String toString() {
            return "File: " + this.filename + "\nRows: " + this.printRows() + "\nPath: " + this.path + "\n";
        }

    }

}
