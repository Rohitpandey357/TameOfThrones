import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * A class to test the output of Tameofthrones class under different scenarios
 */
public class TameofthronesTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    /**
     * A test to check the output when there are more than 2 allied kingdoms
     */
    @Test
    public void tameOfThronesWithAtLeastThreeAlliedKingdomsTest() {
        String filepath = "src\\test\\resources\\sampleinput3.txt";
        Tameofthrones.main(new String[]{filepath});
        assertEquals("SPACE LAND ICE FIRE ", outContent.toString());
    }

    /**
     * A test to check the output when there is no allied kingdoms
     */
    @Test
    public void tameOfThronesWithNoAlliedKingdomsTest() {
        String filepath = "src\\test\\resources\\sampleinput4.txt";
        Tameofthrones.main(new String[]{filepath});
        assertEquals("NONE", outContent.toString());
    }

}
