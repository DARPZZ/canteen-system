package View;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class BackButton extends Button
{
    public BackButton()
    {
        this.setId("back-button");
        this.setFocusTraversable(false);
        this.setLayoutX(50);
        this.setLayoutY(25);
    }
}
