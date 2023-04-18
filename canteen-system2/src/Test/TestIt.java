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
        Assertions.assertTrue(pin.matches("\\d{4}")); // regex for 4-digit PIN code
    }

    // Out case: PIN code with more than 4 digits
    @Test
    void testPinCode_Out() {
        String pin = "12345";
        Assertions.assertFalse(pin.matches("\\d{4}")); // regex for 4-digit PIN code
    }

    // On case: PIN code with all zeroes
    @Test
    void testPinCode_On() {
        String pin = "0000";
        Assertions.assertTrue(pin.matches("\\d{4}")); // regex for 4-digit PIN code
    }

    // Off case: PIN code with all nines
    @Test
    void testPinCode_Off() {
        String pin = "9999";
        Assertions.assertTrue(pin.matches("\\d{4}")); // regex for 4-digit PIN code
    }

}
