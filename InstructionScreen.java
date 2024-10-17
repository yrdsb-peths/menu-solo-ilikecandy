import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionScreen extends World
{
    private String[] instructions = new String[3];
    private int currentInstructionIndex = 0;
    private Label instructionLabel;
    
    private World previousWorld;
    
    public InstructionScreen(World previous)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        previousWorld = previous;
        
        // add instructions
        instructions[0] = "Instructions #1/3: clone the repo";
        instructions[1] = "Instructions #2/3: follow the readme";
        instructions[2] = "Instructions #3/3: stack and queue";
        
        instructionLabel = new Label(instructions[0], 36);
        addObject(instructionLabel, 300, 100);

        addObject(new Button(this::back), 100, 340);
        addObject(new Button(this::next), 500, 340);
    }
    
    
    private void next() {
        if (currentInstructionIndex < instructions.length - 1) {
            currentInstructionIndex++;
            updateInstrutions();
        }
        
    }
    
    private void back() {
        if (currentInstructionIndex >= 1) {
            currentInstructionIndex--;
            updateInstrutions();
        } else {
            Greenfoot.setWorld(previousWorld);
        }
    
    }
    
    private void updateInstrutions() {
        instructionLabel.setValue(instructions[currentInstructionIndex]);
    }
}
