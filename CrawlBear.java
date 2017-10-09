
public class CrawlBear {

	private int health;
	private int jumpHeight;
	private int moveSpeed;
	private int xPosition;
	private int yPosition;
	private String form;


public CrawlBear() {
	
	this.health = 0;
	this.jumpHeight = 0;
	this.moveSpeed = 0;
	this.xPosition = 0;
	this.yPosition = 0;
	this.form = "";
}

public CrawlBear(int health, int jumpHeight, int moveSpeed, int xPosition, int yPosition, String form)
{
	this.health = health;
	this.jumpHeight = jumpHeight;
	this.moveSpeed = moveSpeed;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
	this.form = form;
}

public CrawlBear(CrawlBear c) {
	this.health = c.getHealth(5);
	this.jumpHeight = c.getJumpHeight(3);
	this.moveSpeed = c.getMoveSpeed(7);
	this.xPosition = c.getXPosition();
	this.yPosition = c.getYPosition();
	this.form = c.getForm();
	
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

public String getForm()
{
	return form;
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

public void setForm(String form)
{
	this.form = form;
}



}