
package com.bear.world;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import com.bear.rendering.textures.Texture;


public class Tile {

    private static final Texture            terrain = new Texture("spritesheet_template4.0");
    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
    protected Texture                       sprite;
    protected boolean                       solid;
    protected int                           id;
    protected boolean door;
    protected boolean pickup;
    protected int pickupNumber;
    
    public static final Tile tile1 = new Tile(0xFFFFFFFF, new Texture(terrain, 4, 2, 64));//door
    public static final Tile tile2 = new Tile(0xFFFF0000, new Texture(terrain, 1, 3, 64));//solid
    public static final Tile tile3 = new Tile(0xFFFFA103, new Texture(terrain, 3, 1, 64));//pickup
   
    

    private Tile(int id, Texture sprite) {
        this.id = id;
        this.sprite = sprite;
        solid = true;
        tileMap.put(id, this);
        if(id == 0xFFFFFFFF)
        {
        	door = true;
        }
        if(id == 0xFFFFA103) {
        	pickup = true;
        }
    }

    public void render(Graphics2D g, int x, int y) {
        sprite.render(g, x, y);
    }

    public boolean isSolid() {
        return solid;
    }

    public static Tile getFromID(int id) {
        return tileMap.get(id);
    }
    
    public boolean isDoor() {
    	return door;
    }
    
    public boolean isPickup() {
    	return pickup;
    }
    
    public int NumberOfPickups() {
    	if(id == 0xFFFFA103 && isPickup()) {
    		pickupNumber++;
    		return pickupNumber;
    	}
    	else
    	return 0;
    }

}
