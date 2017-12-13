import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Graphics 
{
	public static Texture loadTexture(String key)
	{
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
