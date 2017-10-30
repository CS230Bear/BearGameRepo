import java.awt.Graphics;

public interface State {
	//public static final int MENU = 0, GAME = 1;
	public void init();
	public void enter();
	public void tick(StateManager stateManager);
	public void render(Graphics g);
	public void exit();
	public String getName();
	
}

