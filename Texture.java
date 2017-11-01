import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Texture {

    private final static Map<String, TextureManager> texMap = new HashMap<String, TextureManager>();

    private TextureManager manager;
    private TextureManager manager1;
    private String        fileName;
    private int           width, height;

    public Texture(String fileName) {
      //  this.fileName = fileName;
        TextureManager oldTexture = texMap.get(fileName);
        if (oldTexture != null) {
            manager = oldTexture;
        	manager.addReference();
      
    }
    
    else {
    	try {
			manager = new TextureManager(ImageIO.read(new File("./resources/textures/" + fileName + ".png")));
			//manager1 = new TextureManager(ImageIO.read(new File("bear.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
     
        
    }
    
protected void finalize() throws Throwable{
	if(manager.removeRefernece() && !fileName.isEmpty()) texMap.remove(fileName);
	super.finalize();
}

public void render(Graphics g, double x, double y) {
	g.drawImage(manager.getImage(), (int) x, (int) y, null);
}

public BufferedImage getImage() {
	return manager.getImage();
}
   
}