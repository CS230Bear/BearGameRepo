import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter  {

	private static final int NUM_BUTTONS = 10;
	
	private static final boolean[] buttons = new boolean[NUM_BUTTONS];
	private static final boolean[] lastButtons = new boolean[NUM_BUTTONS];
	private static int dragX = -1, dragY = -1;
	private static int x = -1, y = -1;
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Button " + e.getButton());
		buttons[e.getButton()] = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
	}
	
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
	}
	
	public static void update() {
		for(int i = 0; i < NUM_BUTTONS; i++) {
			lastButtons[i] = buttons[i];
		}
		
		
	}
	
	public static boolean isDown(int button) {
		return buttons[button];
	}
	
	public static boolean wasPressed(int button) {
		return isDown(button) && !lastButtons[button];
	}
	
	public static boolean wasReleased(int button) {
		return !isDown(button) && lastButtons[button];
	}
}

