import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestIO {
    @Test
    public void Java6FileWriterWorksCorrectly() throws Exception {
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("text.txt")))) {
            pw.println("I'm a sentence in a text-file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}