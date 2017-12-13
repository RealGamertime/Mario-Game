import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Graphics 
{
	public static Texture loadTexture(String key)
	{
		/**
		 * TODO
		 * Make it so key has the extension name in it and this will find the extension value.
		 */
		try {
			return TextureLoader.getTexture("png", new FileInputStream(new File("res/" + key + ".png")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
