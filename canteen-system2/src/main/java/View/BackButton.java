package View;

import javafx.scene.control.Button;

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
