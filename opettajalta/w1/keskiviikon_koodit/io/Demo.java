package fi.academy.keskiviikko.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(".");
        Stream<Path> virta = Files.list(dir);
        virta.filter(Files::isRegularFile)
             .map(p->p.getFileName())
             .forEach(System.out::println);
    }
}
