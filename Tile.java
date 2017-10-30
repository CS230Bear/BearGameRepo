import java.awt.Graphics;

public class Tile {

	protected float x, y;
	protected Sprite sprite;
	protected boolean solid;
	
	public Tile(float x, float y, Sprite sprite) {
		super();
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.solid = true;
	}
	
	public void render(Graphics g) {
		sprite.render(g, x, y);
	}
	
	
}
