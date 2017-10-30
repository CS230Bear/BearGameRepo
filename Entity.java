import java.awt.Graphics;

public abstract class Entity {

	protected double x, y;
	protected Sprite sprite;
	protected GameState state;
	
	
	public Entity(Sprite sprite, double x, double y, GameState state) {
		super();
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.state = state;
		this.state.addEntity(this);
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		sprite.render(g, x, y);
	}
	
	
	
	
	
}
