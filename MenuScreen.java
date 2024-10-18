import greenfoot.*;
import java.util.Map;
import java.util.HashMap;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatarImages = new Queue<>();
    private Avatar avatar;
    
    private Map<String, Integer> scores = new HashMap<>();
    
    public MenuScreen() {
        super(600, 400, 1);
        addObject(new Button(this::goInstructions), 300, 340);
    
        avatarImages.enqueue(new GreenfootImage("images/face_a.png"));
        avatarImages.enqueue(new GreenfootImage("images/face_b.png"));
        avatarImages.enqueue(new GreenfootImage("images/face_c.png"));
        
        // set the first avatar
        GreenfootImage nextAvatar = avatarImages.dequeue();
        avatarImages.enqueue(nextAvatar);
        avatar = new Avatar(nextAvatar);
        
        addObject(avatar, 300, 100);
        
        //avatar button
        addObject(new Button(this::nextAvatar), 300, 200);
        
        // high scores
        scores.put("name 1", 100);
        scores.put("name 2", 200);
        scores.put("Jacob", 10000);
        
        // display high scores
        int offsetY = 0;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
            addObject(new Label(key + ": " + value, 30), 100, 200 - offsetY);
            offsetY += 25;
        }
        
    }

    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }

    private void nextAvatar() {
        // get the next avatar image
        GreenfootImage nextAvatar = avatarImages.dequeue();
        // enqueue it back so it loops
        avatarImages.enqueue(nextAvatar);
        avatar.setImage(nextAvatar);
    }
}