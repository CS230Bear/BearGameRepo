import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class BearMovement extends Entity { // Extends our class
 int velX = 0, velY = 0;


public BearMovement(int x, int y) { //replace this with our bear class
	super(x, y);
}

public void update() {
	y += velY;
	x += velX;
}

public void draw(Graphics2D g2d) {
	g2d.drawImage(getPlayerImg(), x, y, null);
}

public Image getPlayerImg() {
	ImageIcon ic = new ImageIcon("/Users/JordanSkerda/eclipse-workspace/Bear/src/bear.png");
	return ic.getImage();
}

public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_W) {
		velY = -2;
	} else if ( key == KeyEvent.VK_S) {
		velY = 2;
	} else if (key == KeyEvent.VK_A) {
		velX = -2;
	} else if (key == KeyEvent.VK_D) {
		velX = 2;
	}
}

public void keyReleased(KeyEvent e) {
int key = e.getKeyCode();
	
if (key == KeyEvent.VK_W) {
	velY = -0;
} else if (key == KeyEvent.VK_S) {
	velY= 0;
} else if (key == KeyEvent.VK_A) {
	velX = -0;
} else if (key == KeyEvent.VK_D) {
	velX = 0;
	}
}



}
	




