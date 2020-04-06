import domain.Person;
import domain.PersonSpliterator;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorExample {


    @Test
    public void testStuff(){
        Path path = Paths.get("people.txt");
        try {
            Stream<String> lines = Files.lines(path);
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);
            Stream<Person> streamOfPpl = StreamSupport.stream(personSpliterator, false);
            streamOfPpl.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
