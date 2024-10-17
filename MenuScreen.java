import greenfoot.*;

public class MenuScreen extends World {
  public MenuScreen() {
    super(600, 400, 1);

    addObject(new Button(this::goInstructions), 300, 340);
  }

  public void goInstructions() {
    Greenfoot.setWorld(new InstructionScreen(this));
  }

}