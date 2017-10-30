import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu implements State {

	
	
	//private final String[] options = {"Play", "Options", "Exit"};// selection 0, 1, or 2
	private Button[] options;
	private int currentSelection;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		options = new Button[3];
		options[0] = new Button("Play", 200 +0 *90,
				new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
				Color.WHITE, Color.YELLOW);
		options[1] = new Button("Options", 200 +1 *90,
				new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
				Color.WHITE, Color.YELLOW);
		options[2] = new Button("Exit", 200 +2 *90,
				new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
				Color.WHITE, Color.YELLOW);
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void tick(StateManager stateManager) {
		boolean clicked = false;
		for(int i =0; i < options.length; i++) {
			if(options[i].intersects(new Rectangle(MouseInput.getX(), MouseInput.getY(),1,1))) {
				currentSelection = i;
				clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
		}
			
		}
		
		if(KeyInput.wasKeyPressed(KeyEvent.VK_UP) || KeyInput.wasKeyPressed(KeyEvent.VK_W)) {
			currentSelection--;
			if(currentSelection < 0) currentSelection = options.length - 1;
		}
		
		if(KeyInput.wasKeyPressed(KeyEvent.VK_DOWN) || KeyInput.wasKeyPressed(KeyEvent.VK_S)) {
			currentSelection++;
			if(currentSelection >= options.length) currentSelection = 0;
		}
		
		if(clicked || KeyInput.wasKeyPressed(KeyEvent.VK_ENTER)) 
			select(stateManager);
	}
	
	private void select(StateManager stateManager) {
		switch(currentSelection) {
		case 0:
			stateManager.setState("Level1");
			break;
		case 1:
			System.out.println("Options");
			break;
		case 2:
			System.out.println("Exit");
			Game.INSTANCE.stop();
			break;
		}
	}
	
	
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		Fonts.drawString(g, new Font("Arial", Font.BOLD, 72),Color.ORANGE, Game.TITLE, 88);
		
		for(int i = 0; i < options.length; i++) {
			if(i == currentSelection) 
				options[i].setSelected(true);
			else options[i].setSelected(false);
			
			options[i].render(g);
			//	Fonts.drawString(g, new Font("Arial", Font.BOLD, 48), Color.YELLOW, options[i], 200 + i * 80);
		//	else Fonts.drawString(g, new Font("Arial", Font.PLAIN, 32), Color.WHITE, options[i], 200 + i * 80);
		}
	}

	

	

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "menu";
	}
}
