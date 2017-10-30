
public abstract class Mob extends Entity {
	
	protected double dx, dy;
	

	public Mob(Sprite sprite, double x, double y, GameState state) {
		super(sprite, x, y, state);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick() {
		move();
}
	public void move() {
		x += dx;
		y += dy;
	}
	
	
}
