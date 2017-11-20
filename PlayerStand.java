
package com.bear.entities;


import java.awt.event.KeyEvent;

import com.bear.input.KeyInput;
import com.bear.rendering.textures.Animation;
import com.bear.rendering.textures.Texture;
import com.bear.world.TileMap;


public class PlayerStand extends Mob {

    public PlayerStand(double x, double y, TileMap tileMap) {
        super(new Texture(new Texture("spritesheet_stand"), 3, 1, 64), x, y, tileMap,
                new Animation(5,
                        new Texture(new Texture("spritesheet_stand"), 1, 1, 64),
                        new Texture(new Texture("spritesheet_stand"), 2, 1, 64)));
        	                        /*new Texture(new Texture("player_sheet"), 3, 1, 64),
                        new Texture(new Texture("player_sheet"), 4, 1, 64),
                        new Texture(new Texture("player_sheet"), 1, 2, 64),
                        new Texture(new Texture("player_sheet"), 2, 2, 64)));*/

    }
    


    @Override
    public void tick() {
        if(KeyInput.isDown(KeyEvent.VK_SPACE)) jump(20);
//        if(KeyInput.isDown(KeyEvent.VK_S)) dy = 2;a
        if(KeyInput.isDown(KeyEvent.VK_A)) dx = -2;
        if(KeyInput.isDown(KeyEvent.VK_D)) dx = 2;
        if(KeyInput.isDown(KeyEvent.VK_SHIFT))
        {
        	
        }
        	
        
        
//        if(KeyInput.wasReleased(KeyEvent.VK_W) || KeyInput.wasReleased(KeyEvent.VK_S)) dy = 0;
        if(KeyInput.wasReleased(KeyEvent.VK_A) || KeyInput.wasReleased(KeyEvent.VK_D)) dx = 0;
        super.tick();
    }

}
