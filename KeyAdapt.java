import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	
	BearMovement b;
	
	public KeyAdapt(BearMovement bear) {
b = bear;
}
	
	public void keyPressed(KeyEvent e) {
		b.keyPressed(e);
}
	
	public void keyReleased(KeyEvent e) {
		b.keyReleased(e);
	}
}