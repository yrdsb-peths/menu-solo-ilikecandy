import greenfoot.*;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatarImages = new Queue<>();
    private Avatar avatar;
    
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