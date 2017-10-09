import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

// this is all about the jframe. Canvas allows things to be drawn
public class DisplayScreen 
{
	public JFrame frame;
	public Canvas canvas;
	
	public String title;
	public int width, height;
	
	public DisplayScreen(String title, int width, int height)
	{
		this.title =title;
		this.width = width;
		this.height = height;
		
		createDisplayScreen();
		
	}
	
	public void createDisplayScreen()
	{
		// capabilities of the Jframe
		frame = new JFrame(title);
		frame.setSize(width,  height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack(); 
	}
	
	public Canvas getCanvas()
	{
		return canvas;
		
	}
	
	

}
