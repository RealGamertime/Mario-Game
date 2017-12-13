import static org.lwjgl.opengl.GL11.*;
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
		if(key.equals(""))
			return null;
		try {
			return TextureLoader.getTexture("png", new FileInputStream(new File("res/" + key + ".png")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static void drawRect(float x, float y, float width, float height)
	{
		drawRect(x,y,width,height, 0, "");
	}
	public static void drawRect(float x, float y, float width, float height, String tex)
	{
		drawRect(x,y,width,height, 0, tex);
	}
	public static void drawRect(float x, float y, float width, float height, float rot)
	{
		drawRect(x,y,width,height, rot, "");
	}
	public static void drawRect(float x, float y, float width, float height, float rot, String tex)
	{
		
		Texture tempTex = loadTexture(tex);
		if(tempTex != null)
		{
			tempTex.bind();
		}
		glPushMatrix();
		{
			glTranslatef(x,y,0);
			glRotatef(rot,0,0,1);
			
			glBegin(GL_QUADS);
			{
				glVertex2f(0, 0);
				glVertex2f(0, height);
				glVertex2f(width, height);
				glVertex2f(width, 0);
			}
			glEnd();
		}
		glPopMatrix();
	}
}
