import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	
	Timer mainTimer;
	BearMovement bear;
	
	public GameFrame() { 
 setFocusable(true);

 
 bear = new BearMovement(100, 100);
 
 addKeyListener(new KeyAdapt(bear));
 
 mainTimer = new Timer(10, this);
 mainTimer.start();
}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		bear.draw(g2d);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		bear.update();
		repaint();
		
	}
}
