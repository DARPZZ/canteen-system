import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIt {
    @BeforeEach

    void setup()
    {

    }
    @AfterEach
    void teardown()
    {

    }

    @Test
    void testPinCode_In() {
        String pin = "1234";
        Assertions.assertTrue(pin.matches("\\d{4}"));
    }

    // Out case:
    @Test
    void testPinCode_Out() {
        String pin = "12345";
        Assertions.assertFalse( pin.matches("\\d{4}"));
    }

    // On case:
    @Test
    void testPinCode_On() {
        String pin = "0000";
        Assertions.assertTrue(pin.matches("\\d{4}"));
    }

    // Off case:
    @Test
    void testNumericInput()
    {
        String pin = "1234";
        Assertions.assertTrue(pin.matches("\\d+"));
    }

}
