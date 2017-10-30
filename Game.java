import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "Bear Game";
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;//WIDTH / 4 * 3;
	
	private boolean running;
	private StateManager stateManager;
	
	public static Game INSTANCE; 
	
	public Game() {
		
		addKeyListener(new KeyInput());
		MouseInput mi = new MouseInput();
		addMouseListener(mi);
		addMouseMotionListener(mi);
		stateManager = new StateManager();
		
		stateManager.addState(new Menu());
		stateManager.addState(new GameState());
		INSTANCE = this;
	
	}
	
	private void tick() {
		stateManager.tick();
	}
	
		

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		stateManager.render(g);
		
		
		/*texture.render(g, 100, 100);//sample texture render
		sprite.render(g, sX,sY);//sample sprite render
		*/
		
		g.dispose();
		bs.show();
	}
	
	protected void start() {
		if(running) return;
		running = true;
		new Thread(this,"BearGameMain-Thread").start();
	}
	
	public void stop() {
		if (!running) return;
		running = false;
	}
	
	@Override
	public void run() {
		
		requestFocus();
		double target = 60.0;
		double nsPerTick = 1000000000.0 / target;
		double unprocessed = 0.0;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		while(running)
		{
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			
			if(unprocessed >= 1.0) {
				tick();
				MouseInput.update();
				KeyInput.update();
				unprocessed--;
				tps++;
				canRender = true;
			}else canRender = false;//basically caps fps at 60
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(canRender){
				render();
				fps++;
			}
			
			if(System.currentTimeMillis() - 1000 > timer)
			{
				timer += 1000;
				System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
				fps = 0;
				tps=0;
			}
		}
		
		System.exit(0);
	}
	


	
}
