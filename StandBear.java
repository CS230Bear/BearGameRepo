
public class StandBear {

	private int health;
	private int jumpHeight;
	private int moveSpeed;
	private int xPosition;
	private int yPosition;


public StandBear() {
	
	this.health = 0;
	this.jumpHeight = 0;
	this.moveSpeed = 0;
	this.xPosition = 0;
	this.yPosition = 0;
}

public StandBear(int health, int jumpHeight, int moveSpeed, int xPosition, int yPosition)
{
	this.health = health;
	this.jumpHeight = jumpHeight;
	this.moveSpeed = moveSpeed;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
}

public StandBear(StandBear b) {
	this.health = b.getHealth(5);
	this.jumpHeight = b.getJumpHeight(3);
	this.moveSpeed = b.getMoveSpeed(7);
	this.xPosition = b.getXPosition();
	this.yPosition = b.getYPosition();
	
}

public int getHealth(int health)
{
	return health;
}

public int getJumpHeight(int jumpHeight)
{
	return jumpHeight;
}

public int getMoveSpeed(int moveSpeed)
{
	return moveSpeed;
}

public int getXPosition()
{
	return xPosition;
}

public int getYPosition()
{
	return yPosition;
}

public void setHealth(int health)
{
	this.health = health;
}

public void setJumpHeight(int jumpHeight)
{
	this.jumpHeight = jumpHeight;
}

public void setMoveSpeed(int moveSpeed)
{
	this.moveSpeed = moveSpeed;
}

public void setXPosition(int xPosition)
{
	this.xPosition = xPosition;
}

public void setYPosition(int yPosition)
{
	this.yPosition = yPosition;
}



}