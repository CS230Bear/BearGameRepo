import java.awt.event.KeyEvent;

public class Bear extends Mob{

	public Bear(Sprite sprite, double x, double y, GameState state) {
		super(sprite, x, y, state);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void tick() {
		if(KeyInput.isKeyDown(KeyEvent.VK_W)) dy = -2;
		if(KeyInput.isKeyDown(KeyEvent.VK_S)) dy = 2;
		if(KeyInput.isKeyDown(KeyEvent.VK_A)) dx = -2;
		if(KeyInput.isKeyDown(KeyEvent.VK_D)) dx = 2;
		
		if(KeyInput.wasReleased(KeyEvent.VK_W) || KeyInput.wasReleased(KeyEvent.VK_S)) dy = 0;
		if(KeyInput.wasReleased(KeyEvent.VK_A) || KeyInput.wasReleased(KeyEvent.VK_D)) dx = 0;
		super.tick();
	}

}
