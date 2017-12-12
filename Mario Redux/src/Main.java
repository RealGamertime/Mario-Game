import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.String;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import static org.lwjgl.opengl.GL11.*;

/**
 *TODO
 * Abstract Block
 * Brick extends Block
 * QuestionMark extends Block
 * Abstract Enemy
 * Goomba extends Enemy
 * Item
 * Physics
 * Player
 * https://github.com/RealGamertime/Mario-Game/blob/master/Mario%20Redux/src/Main.java
 * https://github.com/account/organizations/newv
 * https://wiki.eclipse.org/Karaf_Remote_Management_with_Eclipse
 * test
 */
public class Main {
	
	public static String GAME_NAME = "Mario Redux";
	
	public static void main(String[] args)
	{
		initDisplay();
		initGL();
		gameLoop();
		cleanUp();
		
		
	}
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
	
	private static void gameLoop()
	{
		Texture wood = loadTexture("Mario_brick");
		
		//Game Loop
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			//glColor3f(1f, 1f, 0f);
			
			//glTranslate();
			wood.bind();
			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);
				glTexCoord2f(0, 1);
				glVertex2f(0, 64);
				glTexCoord2f(1, 1);
				glVertex2f(64, 64);
				glTexCoord2f(1, 0);
				glVertex2f(64, 0);
				//glTexCoord2f(64, 0);
			}
			glEnd();
			
			Display.update();
		}
	}
	
	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(0, 50, 255, 1);	
		glClear(GL_COLOR_BUFFER_BIT);
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
	}
	
	private static void cleanUp()
	{
		Display.destroy();
	}
	
	private static void initDisplay()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(1360, 760));
			Display.setFullscreen(true);
			//Display.setInitialBackground(0, 0, 255);
			Display.setTitle(GAME_NAME);
			Display.create();
		}
		catch(LWJGLException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}