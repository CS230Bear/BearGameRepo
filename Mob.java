
package com.bear.entities;

import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import com.bear.beargame.Game;
import com.bear.rendering.textures.Animation;
import com.bear.rendering.textures.Texture;
import com.bear.states.GameState;
import com.bear.states.State;
import com.bear.states.StateManager;
import com.bear.world.TileMap;


public abstract class Mob extends Entity {

	
	protected double    dx, dy;
    protected double    maxDY;
    protected double    gravity;
    protected boolean   falling;
    protected boolean   canJump;
    protected boolean   moving;
    protected Animation anime;

    public Mob(Texture texture, double x, double y, TileMap tileMap, Animation anime) {
        super(texture, x, y, tileMap);
        this.anime = anime;
        gravity = 0.5;
        maxDY = 10;
    }

    @Override
    public void tick() {
        if (dy > 0) 
        	falling = true;
        
        else if (dy < 0) falling = false;
        move();
        fall();
        if (dx != 0) moving = true;
        else moving = false;
        if (moving) anime.run();
        
        if(super.getY() > 1000)
        {
        	super.setY(500);//arbitrary y coordinate to reset the bear to starting position
        	super.setX(0);//arbitrary x coordinate to reset the bear to starting position
        	//System.out.println("falling");
        	JOptionPane.showMessageDialog(null, "You Died!");
        	
        }
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        if (!moving)
            super.render(g, offsetX, offsetY);
        else anime.render(g, x + offsetX, y + offsetY);
       /* if(super.getY() > 1000) 
        {
        	
        	//statemanager.setState("level2");
        //	statemanager.addState(gamestate);
        	//statemanager.render(g);
        	//gamestate.init();
        	//gamestate.render(g);
        //	player.tick();
        	
     
        	System.out.println("weeeeeeeeeee");
        }*/
    }

    public void move() {
        boolean horiz = tileMap.getTileCollision(texture.getWidth(), x, y, x + dx, y, false);
        boolean vert = tileMap.getTileCollision(texture.getWidth(), x, y, x, y + dy, true);
        if (!horiz) x += dx;
        if (!vert) y += dy;
       
    }

    protected void fall() {
        dy += gravity;
        if (dy > maxDY) dy = maxDY;
    }

    protected void jump(double jumpHeight) {
        if (canJump) {
            dy -= jumpHeight;
            canJump = false;
        }
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public void setVelocityY(double dy) {
        this.dy = dy;
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isMovingLeft() {
        return dx < 0;
    }

    public boolean isMovingRight() {
        return dx > 0;
    }

    public boolean isMoving() {
        return moving;
    }

}
