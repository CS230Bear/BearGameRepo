
package com.bear.world;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import com.bear.rendering.textures.Texture;


public class Tile {

    private static final Texture            terrain = new Texture("final");
    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
    protected Texture                       sprite;
    protected boolean                       solid;
    protected int                           id;
    protected boolean door;
    protected boolean pickup;
    protected int pickupNumber;
    protected boolean exit;
    
    public static final Tile tile1 = new Tile(0xFFFFFFFF, new Texture(terrain, 4, 1, 64));//door
    public static final Tile tile2 = new Tile(0xFFFF0000, new Texture(terrain, 1, 3, 64));//solid
    public static final Tile tile3 = new Tile(0xFFFFA103, new Texture(terrain, 3, 1, 64));//pickup
    public static final Tile tile4 = new Tile(0xFFFFFF81, new Texture(terrain, 4, 2, 64));
    public static final Tile tile5 = new Tile(0xFF73BDE6, new Texture(terrain, 2, 1, 64));
    public static final Tile tile6 = new Tile(0xFF00FD47, new Texture(terrain, 2, 2, 64));
    public static final Tile tile7 = new Tile(0xFFFFFF55, new Texture(terrain, 2, 1, 64));
    public static final Tile tile8 = new Tile(0xFFFF5681, new Texture(terrain, 2, 2, 64));
    

    private Tile(int id, Texture sprite) {
        this.id = id;
        this.sprite = sprite;
        solid = true;
        tileMap.put(id, this);
        if(id == 0xFFFFFFFF || id == 0xFFFFFF81)
        {
        	door = true;
        }
        if(id == 0xFFFFA103) {
        	pickup = true;
        }
        
        if(id == 0xFFFFFF55 || id == 0xFFFF5681) {
        	exit = true;
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
    
    public boolean isExit() {
    	return exit;
    }

}
