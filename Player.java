
package com.bear.entities;


import java.awt.event.KeyEvent;

import com.bear.input.KeyInput;
import com.bear.rendering.textures.Animation;
import com.bear.rendering.textures.Texture;
import com.bear.world.TileMap;



public class Player extends Mob {

    public Player(double x, double y, TileMap tileMap) {
        super(new Texture(new Texture("spritesheet_stand"), 1, 1, 64), x, y, tileMap,
                new Animation(5,
                        new Texture(new Texture("spritesheet_stand"), 1, 1, 64),
                        new Texture(new Texture("spritesheet_stand"), 1, 2, 64)));
        	                        /*new Texture(new Texture("player_sheet"), 3, 1, 64),
                        new Texture(new Texture("player_sheet"), 4, 1, 64),
                        new Texture(new Texture("player_sheet"), 1, 2, 64),
                        new Texture(new Texture("player_sheet"), 2, 2, 64)));*/

    }
    


    @Override
    public void tick() {
        if(KeyInput.isDown(KeyEvent.VK_SPACE)) jump(20);
//        if(KeyInput.isDown(KeyEvent.VK_S)) dy = 2;a
        if(KeyInput.isDown(KeyEvent.VK_A) || KeyInput.isDown(KeyEvent.VK_LEFT)) dx = -2;
        if(KeyInput.isDown(KeyEvent.VK_D) || KeyInput.isDown(KeyEvent.VK_RIGHT)) dx = 2;
        if(KeyInput.isDown(KeyEvent.VK_SHIFT))
        {
			new Animation(5,
                    new Texture(new Texture("spritesheet_stand"), 1, 3, 64),
                    new Texture(new Texture("spritesheet_stand"), 1, 3, 64));
        	System.out.println("shift");
        }
        	
        
        
//        if(KeyInput.wasReleased(KeyEvent.VK_W) || KeyInput.wasReleased(KeyEvent.VK_S)) dy = 0;
        if(KeyInput.wasReleased(KeyEvent.VK_A) || KeyInput.wasReleased(KeyEvent.VK_LEFT) || KeyInput.wasReleased(KeyEvent.VK_D) || KeyInput.wasReleased(KeyEvent.VK_RIGHT)) dx = 0;
        super.tick();
    }

}
