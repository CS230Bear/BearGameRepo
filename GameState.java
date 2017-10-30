import java.awt.Graphics;
import java.util.ArrayList;

public class GameState implements State {

	private ArrayList<Entity> entities;
	private ArrayList<Tile> tiles;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		entities = new ArrayList<Entity>();
		tiles = new ArrayList<Tile>();
		new Bear(new Sprite("test"), 100, 100, this);
		float x = 0;
		float y = Game.HEIGHT - 64;
		for(int i = 0; i < 10; i++) {
			tiles.add(new Tile(x, y, new Sprite(new SpriteSheet(new Texture("tile.jpg"),64), 3,1)));
		}
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(StateManager stateManager) {
		// TODO Auto-generated method stub
		for(Entity e : entities) {
			e.tick();
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		for(Entity e : entities) {
			e.render(g);
			
			for(Tile t : tiles) {
				t.render(g);
			}
		}
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		entities.clear();
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "level1";
	}

	public void addEntity(Entity entity) {
		// TODO Auto-generated method stub
		entities.add(entity);
	}

}
