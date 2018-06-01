package function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PrintPrimesTest {

    private static final String leadFile = "lead";
    private static final String goldFile = "src/test/resources/gold";
    private PrintStream out;
    private BufferedReader lead;
    private BufferedReader gold;

    @Before
    public void
    setUp() throws FileNotFoundException {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream(leadFile)));
        lead = new BufferedReader(new FileReader(leadFile));
        gold = new BufferedReader(new FileReader(goldFile));
    }

    @After
    public void
    cleanUp() throws IOException {
        System.setOut(out);
        new File(leadFile).delete();

        if (lead != null) {
            lead.close();
        }
        if (gold != null) {
            gold.close();
        }
    }

    @Test
    public void
    makeSureMatchesGold() throws IOException {
        new PrintPrimes().main();

        String line;
        while ((line = gold.readLine()) != null) {
            assertEquals(line, lead.readLine());
        }
        assertEquals(null, lead.readLine());

    }
}
