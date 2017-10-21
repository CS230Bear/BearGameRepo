import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Texture {

	private final static Map<String, TextureManager> texMap = new HashMap<String, TextureManager>();
	private TextureManager manager;
	private String filename;
	
	
	public Texture(String filename) {
		this.filename = filename;
		TextureManager oldTexture = texMap.get(filename);
		if(oldTexture != null) {
			manager = oldTexture;
			manager.addReference();
			
		}
		else {
			try {
				System.out.println("Loading texture");
				manager = new TextureManager(ImageIO.read(new File("bear.png")));//("./resources/textures/" + filename + ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	protected void finalize() throws Throwable {
		if(manager.removeRefernece() && !filename.isEmpty()) texMap.remove(filename);
		super.finalize();
		System.out.println("removing texture from memory");
	}
	
	public void render(Graphics g, double x, double y) {
		g.drawImage(manager.getImage(), (int) x,(int) y, null);
	}
	
	public BufferedImage getImage() {
		return manager.getImage();
	}
}
