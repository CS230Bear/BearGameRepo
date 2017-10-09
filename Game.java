import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;




public class Game implements Runnable
{

	private DisplayScreen display;
	public int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	
	public BufferStrategy bs;
	public Graphics g;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init()
	{
		display = new DisplayScreen(title, width, height);
	}
	
	private void tick()
	{
		
	}
	// here things show up on screen
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
	// Here you create shapes and color them etc
		g.setColor(Color.magenta);
		g.fillRect(0,0, width, height);
	// Creates non-interactable platforms "platform"
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 450, width, 420);
		
		g.setColor(Color.GREEN);
		g.fillRect(100, 400, 100, 15);
		
		g.setColor(Color.GREEN);
		g.fillRect(300, 200, 100, 15);
		
		g.setColor(Color.GREEN);
		g.fillRect(430, 250, 100, 15);
		
		
		
		//end draw and make them show
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		while(running)
		{
			tick();
			render();	
		}
		
		stop();
	}
	
	public synchronized void start ()
	
	{	if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop ()
	{	if(!running)
		return;
		 running =false;
		 
		 
		try 
	{
		thread.join();
		} catch (InterruptedException e) {
		
		e.printStackTrace();
		}
		
	}
	
}



