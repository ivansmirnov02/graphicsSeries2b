import graphicsSeries2.Main;
import static org.junit.Assert.*;
import org.junit.Test;
public class AppTest {
    @Test
    public void Test() {
        Main main = new Main();
        assertEquals(Main.encodeBarcode("590123412345"), "10100010110100111011001100100110111101001110101010110011011011001000010101110010011101000100101");
    }
}
