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
public class BearGame extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "Bear";
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;//WIDTH / 4 * 3;
	
	private boolean running;
	private Texture texture;
	private SpriteSheet sheet;
	private Sprite sprite;
	private double sX = 350, sY = 300;
	
	public BearGame() {
		texture = new Texture("bear.png");//fill in with a texture
		sheet = new SpriteSheet(new Texture("bear.png"), 32);
		sprite = new Sprite(sheet, 3,1);//3x3 grid
		addKeyListener(new KeyInput());
		MouseInput mi = new MouseInput();
		addMouseListener(mi);
		addMouseMotionListener(mi);
		System.out.println("Button 1: " + MouseEvent.BUTTON1);
		System.out.println("Button 2: " + MouseEvent.BUTTON2);
		System.out.println("Button 3: " + MouseEvent.BUTTON3);
	}
	
	private void tick() {
		if(KeyInput.isKeyDown(KeyEvent.VK_SPACE))
			sY -= 2;
		
		if(KeyInput.wasKeyPressed(KeyEvent.VK_ENTER)) {
	
		
			sY = 300;
			System.out.println("Enter was pressed");
	}
		if(KeyInput.wasReleased(KeyEvent.VK_6))
			System.out.println("G was released");
		
		if(MouseInput.isDown(MouseEvent.BUTTON1))
			System.out.println("Left is pressed");
		if(MouseInput.wasPressed(MouseEvent.BUTTON2))
			System.out.println("middle was pressed");
		if(MouseInput.wasReleased(MouseEvent.BUTTON3))
			System.out.println("Right was pressed");
		
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
		
		
		texture.render(g, 100, 100);//sample texture render
		sprite.render(g, sX,sY);//sample sprite render
		
		
		g.dispose();
		bs.show();
	}
	
	private void start() {
		if(running) return;
		running = true;
		new Thread(this,"BearGameMain-Thread").start();
	}
	
	private void stop() {
		if (!running) return;
		running = false;
	}
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
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
	
	public static void main(String[] args) {
		BearGame game = new BearGame();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.err.println("Exiting Game");
				game.stop();
			}
		});
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setAutoRequestFocus(true);
		game.start();
	}

	
}
